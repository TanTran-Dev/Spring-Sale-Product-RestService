package com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel
public class NewShoppingCartDto {
    @ApiModelProperty(notes = "id người mua hàng", position = 1)
    private String customerId;

    public NewShoppingCartDto() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
