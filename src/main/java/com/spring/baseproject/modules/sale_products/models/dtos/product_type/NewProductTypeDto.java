package com.spring.baseproject.modules.sale_products.models.dtos.product_type;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class NewProductTypeDto {
    @ApiModelProperty(notes = "tên của loại sản phẩm", example = "NOT_EMPTY, VALUE_IN(SMART_PHONE, TELEVISION, LAPTOP", position = 1)
    private String productTypeName;
    @ApiModelProperty(notes = "Image Url", position = 2)
    private String imageUrl;

    public NewProductTypeDto() {
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
