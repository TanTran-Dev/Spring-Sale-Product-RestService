package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.PageDto;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.admin.repositories.AdminRepository;
import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.customer.repositories.CustomerRepository;
import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductPreviewDto;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product.NewShoppingCartProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product.ShoppingCartProductDto;
import com.spring.baseproject.modules.sale_products.models.entities.*;
import com.spring.baseproject.modules.sale_products.repositories.*;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ShoppingCartProductService {
    @Autowired
    private ShoppingCartProductRepository shoppingCartProductRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypesRepository productTypesRepository;

    @Autowired
    private TrademarkRepository trademarkRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdminRepository adminRepository;

    public BaseResponse createShoppingCartProductDto(NewShoppingCartProductDto newShoppingCartProductDto) {
        Product product = productRepository.findFirstById(newShoppingCartProductDto.getProductId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }

        ProductType productType = productTypesRepository.findFirstById(product.getProductType().getId());
        Trademark trademark = trademarkRepository.findFirstById(product.getTrademark().getId());
        Admin admin = adminRepository.findFirstById(product.getAdmin().getId());

        product.setProductType(productType);
        product.setTrademark(trademark);
        product.setAdmin(admin);

        ShoppingCart shoppingCart = shoppingCartRepository.findFirstById(newShoppingCartProductDto.getShoppingCartId());
        if (shoppingCart == null) {
            return new BaseResponse(ResponseValue.SHOPPING_CART_NOT_FOUND);
        }
        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(newShoppingCartProductDto);
        shoppingCartProduct.setProduct(product);
        shoppingCartProduct.setShoppingCart(shoppingCart);

        shoppingCartProductRepository.save(shoppingCartProduct);

        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto(shoppingCartProduct);

        return new BaseResponse(ResponseValue.SUCCESS, shoppingCartProductDto);
    }

    public BaseResponse getPageShoppingCartProductDto(String customerId, List<String> sortBy, List<String> sortType,
                                                      int pageIndex, int pageSize) {
        Customer customer = customerRepository.findFirstById(customerId);
        if (customer == null){
            return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
        }

        Pageable pageable = SortAndPageFactory.createPageable(sortBy, sortType, pageIndex, pageSize, NumberConstants.MAX_PAGE_SIZE);
        Page<ShoppingCartProduct> pageShoppingCartProduct = shoppingCartProductRepository.getPageShoppingCartProduct(customerId, pageable);
        List<ShoppingCartProductDto> shoppingCartProductDtos = new ArrayList<>();

        for (ShoppingCartProduct shoppingCartProduct : pageShoppingCartProduct) {
            ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto(shoppingCartProduct);
            shoppingCartProductDtos.add(shoppingCartProductDto);
        }
        return new BaseResponse(ResponseValue.SUCCESS,
                new PageDto<>(shoppingCartProductDtos, pageShoppingCartProduct.getNumber(),
                        pageShoppingCartProduct.getSize(), pageShoppingCartProduct.getTotalElements()));
    }

    public BaseResponse getShoppingCartProductDto(Integer productId) {
        ShoppingCartProduct shoppingCartProduct = shoppingCartProductRepository.getShoppingCartProduct(productId);
        if (shoppingCartProduct == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto(shoppingCartProduct);
        return new BaseResponse(ResponseValue.SUCCESS, shoppingCartProductDto);
    }

    public BaseResponse updateShoppingCartProduct(String shoppingCartProductID, NewShoppingCartProductDto newShoppingCartProductDto) {
        ShoppingCartProduct shoppingCartProduct = shoppingCartProductRepository.findFirstById(shoppingCartProductID);
        if (shoppingCartProduct == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }

        Product product = productRepository.findFirstById(newShoppingCartProductDto.getProductId());
        shoppingCartProduct.setProduct(product);

        shoppingCartProduct.update(newShoppingCartProductDto);
        shoppingCartProductRepository.save(shoppingCartProduct);

        ShoppingCartProductDto shoppingCartProductDto = new ShoppingCartProductDto(shoppingCartProduct);

        return new BaseResponse(ResponseValue.SUCCESS, shoppingCartProductDto);
    }

    public BaseResponse deleteListShoppingCart(Set<String> shoppingCartProductIDs) {
        shoppingCartProductRepository.deleteAllByIdIn(shoppingCartProductIDs);
        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
