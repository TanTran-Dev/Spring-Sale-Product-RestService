package com.spring.baseproject.modules.sale_products.models.dtos.product_type;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class NewProductTypeDto {
    @ApiModelProperty(notes = "tên của loại sản phẩm", example = "NOT_EMPTY, VALUE_IN(SMART_PHONE, TELEVISION, LAPTOP", position = 1)
    private String productTypeName;

    public NewProductTypeDto() {
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
