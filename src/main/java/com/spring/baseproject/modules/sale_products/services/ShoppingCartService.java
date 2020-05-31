package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.customer.repositories.CustomerRepository;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart.ShoppingCartDto;
import com.spring.baseproject.modules.sale_products.models.entities.ShoppingCart;
import com.spring.baseproject.modules.sale_products.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public BaseResponse getShoppingCart(String customerId) {
        ShoppingCartDto shoppingCartDto = shoppingCartRepository.getShoppingCart(customerId);

        if (shoppingCartDto == null) {
            Customer customer = customerRepository.findFirstById(customerId);
            if (customer == null) {
                return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
            }
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setCustomer(customer);
            shoppingCart = shoppingCartRepository.save(shoppingCart);

            shoppingCartDto = new ShoppingCartDto(shoppingCart);
        }
        return new BaseResponse(ResponseValue.SUCCESS, shoppingCartDto);
    }
}
