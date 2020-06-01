package com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product;

import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart.ShoppingCartDto;
import com.spring.baseproject.modules.sale_products.models.entities.ProductTypeName;
import com.spring.baseproject.modules.sale_products.models.entities.ShoppingCartProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@ApiModel
public class ShoppingCartProductDto {
    @ApiModelProperty(notes = "id")
    private String id;

    @ApiModelProperty(notes = "sản phẩm trong giỏ hàng", position = 1)
    private ProductDto productDto;

    @ApiModelProperty(notes = "giỏ hàng", position = 2)
    private ShoppingCartDto shoppingCartDto;

    @ApiModelProperty(notes = "số lượng", position = 3)
    private int count;

    public ShoppingCartProductDto() {
    }

    public ShoppingCartProductDto(ShoppingCartProduct shoppingCartProduct) {
        BeanUtils.copyProperties(shoppingCartProduct, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public ShoppingCartDto getShoppingCartDto() {
        return shoppingCartDto;
    }

    public void setShoppingCartDto(ShoppingCartDto shoppingCartDto) {
        this.shoppingCartDto = shoppingCartDto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
