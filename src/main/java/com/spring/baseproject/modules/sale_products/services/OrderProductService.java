package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.PageDto;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.admin.models.dtos.AdminDto;
import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.admin.repositories.AdminRepository;
import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.customer.repositories.CustomerRepository;
import com.spring.baseproject.modules.sale_products.models.dtos.order_product.NewOrderProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.order_product.OrderProductPreviewDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart.ShoppingCartDto;
import com.spring.baseproject.modules.sale_products.models.entities.OrderProduct;
import com.spring.baseproject.modules.sale_products.models.entities.Product;
import com.spring.baseproject.modules.sale_products.models.entities.ShoppingCart;
import com.spring.baseproject.modules.sale_products.repositories.OrderProductRepository;
import com.spring.baseproject.modules.sale_products.repositories.ProductRepository;
import com.spring.baseproject.modules.sale_products.repositories.ShoppingCartRepository;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OrderProductService {
    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public BaseResponse createNewOrder(NewOrderProductDto newOrderProductDto) {
        Product product = productRepository.findFirstById(newOrderProductDto.getProductId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
        ProductDto productDto = new ProductDto(product);

        Customer customer = customerRepository.findFirstById(newOrderProductDto.getCustomerId());
        if (customer == null) {
            return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
        }
        CustomerDto customerDto = new CustomerDto(customer);
        Admin admin = adminRepository.findFirstById(newOrderProductDto.getAdminId());
        if (admin == null) {
            return new BaseResponse(ResponseValue.ADMIN_NOT_FOUND);
        }
        AdminDto adminDto = new AdminDto(admin);

        ShoppingCart shoppingCart = shoppingCartRepository.findFirstById(newOrderProductDto.getShoppingCartId());
        if (shoppingCart == null) {
            return new BaseResponse(ResponseValue.SHOPPING_CART_NOT_FOUND);
        }
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto(shoppingCart);
        OrderProduct orderProduct = new OrderProduct(product, customer, admin, shoppingCart, newOrderProductDto);

        orderProductRepository.save(orderProduct);

        OrderProductPreviewDto orderProductPreviewDto =
                new OrderProductPreviewDto(productDto, customerDto, adminDto, shoppingCartDto, orderProduct);

        return new BaseResponse(ResponseValue.SUCCESS, orderProductPreviewDto);
    }

    public BaseResponse getPageOrderProductPreviewDtos(String customerId, List<String> sortBy, List<String> sortType, int pageIndex, int pageSize) {

        Pageable pageable = SortAndPageFactory.createPageable(sortBy, sortType, pageIndex, pageSize, NumberConstants.MAX_PAGE_SIZE);
        Page<OrderProduct> pageResult = orderProductRepository.getPageOrderProduct(customerId, pageable);

        List<OrderProductPreviewDto> listResult = new ArrayList<>();
        for (OrderProduct orderProduct : pageResult.getContent()) {
            Product product = productRepository.findFirstById(orderProduct.getProduct().getId());
            ProductDto productDto = new ProductDto(product);

            Customer customer = customerRepository.findFirstById(orderProduct.getCustomer().getId());
            CustomerDto customerDto = new CustomerDto(customer);

            Admin admin = adminRepository.findFirstById(orderProduct.getAdmin().getId());
            AdminDto adminDto = new AdminDto(admin);

            ShoppingCart shoppingCart = shoppingCartRepository.findFirstByCustomerId(customer.getId());
            ShoppingCartDto shoppingCartDto = new ShoppingCartDto(shoppingCart);

            OrderProductPreviewDto orderProductPreviewDto = new OrderProductPreviewDto(
                    productDto, customerDto, adminDto, shoppingCartDto, orderProduct);
            listResult.add(orderProductPreviewDto);
        }
        PageDto<OrderProductPreviewDto> result = new PageDto<>(listResult, pageResult.getNumber(), pageResult.getSize(), pageResult.getTotalElements());

        return new BaseResponse(ResponseValue.SUCCESS, result);
    }

    public BaseResponse getOrderProductPreviewDto(String orderId) {
        OrderProduct orderProduct = orderProductRepository.getOrderProduct(orderId);

        Product product = productRepository.findFirstById(orderProduct.getProduct().getId());
        ProductDto productDto = new ProductDto(product);
        Customer customer = customerRepository.findFirstById(orderProduct.getCustomer().getId());
        CustomerDto customerDto = new CustomerDto(customer);

        Admin admin = adminRepository.findFirstById(orderProduct.getAdmin().getId());
        AdminDto adminDto = new AdminDto(admin);

        ShoppingCart shoppingCart = shoppingCartRepository.findFirstByCustomerId(customer.getId());
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto(shoppingCart);
        if (orderProduct == null) {
            return new BaseResponse(ResponseValue.ORDER_PRODUCT_NOT_FOUND);
        }

        OrderProductPreviewDto orderProductPreviewDto = new OrderProductPreviewDto(productDto, customerDto, adminDto, shoppingCartDto, orderProduct);
        return new BaseResponse(ResponseValue.SUCCESS, orderProductPreviewDto);
    }

    public BaseResponse deleteListOrderProducts(Set<String> orderIds) {
        orderProductRepository.deleteAllByIdIn(orderIds);
        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
