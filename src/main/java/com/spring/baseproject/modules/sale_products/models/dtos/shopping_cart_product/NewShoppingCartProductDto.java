package com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class NewShoppingCartProductDto {
    @ApiModelProperty(notes = "id sản phẩm")
    private int productId;

    @ApiModelProperty(notes = "id giỏ hàng")
    private String shoppingCartId;

    @ApiModelProperty(notes = "số lượng sản phẩm")
    private int count;

    public NewShoppingCartProductDto() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
