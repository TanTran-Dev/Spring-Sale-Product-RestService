package com.spring.baseproject.modules.sale_products.models.dtos.product_type;

import com.spring.baseproject.modules.sale_products.models.entities.ProductTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class NewProductTypeDto {
    @ApiModelProperty(notes = "tên của loại sản phẩm", example = "NOT_EMPTY, VALUE_IN(SMART_PHONE, TELEVISION, LAPTOP", position = 1)
    private ProductTypeName productTypeName;

    public NewProductTypeDto() {
    }

    public ProductTypeName getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(ProductTypeName productTypeName) {
        this.productTypeName = productTypeName;
    }
}
