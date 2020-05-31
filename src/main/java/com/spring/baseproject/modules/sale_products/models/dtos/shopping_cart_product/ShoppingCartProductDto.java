package com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product;

import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart.ShoppingCartDto;
import com.spring.baseproject.modules.sale_products.models.entities.ShoppingCartProduct;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.BeanUtils;

@ApiModel
public class ShoppingCartProductDto {
    private int id;
    private ProductDto productDto;
    private ShoppingCartDto shoppingCartDto;
    private int count;

    public ShoppingCartProductDto() {
    }

    public ShoppingCartProductDto(ShoppingCartProduct shoppingCartProduct) {
        BeanUtils.copyProperties(shoppingCartProduct, this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
