package com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart;

import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import com.spring.baseproject.modules.sale_products.models.entities.ShoppingCart;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.Date;

@ApiModel
public class ShoppingCartDto {
    @ApiModelProperty(notes = "id giỏ hàng")
    private String id;

    @ApiModelProperty(notes = "thồng tin người mua", position = 1)
    private CustomerDto customerDto;

    public ShoppingCartDto(ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
        this.customerDto = new CustomerDto(shoppingCart.getCustomer());
    }

//    public ShoppingCartDto(ShoppingCart shoppingCart) {
//        this.id = shoppingCart.getId();
//        this.productDtos = new ArrayList<>();
//        for (Product product : shoppingCart.getProducts()){
//            ProductDto productDto = new ProductDto(product);
//            productDtos.add(productDto);
//        }
//    }


    public ShoppingCartDto(String id,
                           String customerId, String firstName, String lastName, Date birthday,
                           String address, String phone, Gender gender, String avatarUrl, String imageCoverUrl,
                           String userId, String username, Boolean isBanner, Date lastActive) {
        this.id = id;
        this.customerDto = new CustomerDto(customerId, firstName, lastName,
                address, birthday, phone, gender, avatarUrl, imageCoverUrl, userId, username, isBanner, lastActive);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }
}
