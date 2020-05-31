package com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product;

import io.swagger.annotations.ApiModel;

@ApiModel
public class NewShoppingCartProductDto {
    private int productId;
    private int shoppingCartId;
    private int count;

    public NewShoppingCartProductDto() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
