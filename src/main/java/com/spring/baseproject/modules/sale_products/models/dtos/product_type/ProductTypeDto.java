package com.spring.baseproject.modules.sale_products.models.dtos.product_type;

import com.spring.baseproject.modules.sale_products.models.entities.ProductTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class ProductTypeDto {
    @ApiModelProperty(notes = ("id loại sản phẩm"))
    private int id;

    @ApiModelProperty(notes = ("tên loại sản phẩm"))
    private ProductTypeName name;

    public ProductTypeDto() {
    }

    public ProductTypeDto(Integer id, ProductTypeName name) {
        this.id = id;
        this.name = name;
    }

//    public ProductTypeDto(Integer id, ProductTypeName name) {
//        this.id = id == null ? -1 : id;
//        this.name = name;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductTypeName getName() {
        return name;
    }

    public void setName(ProductTypeName name) {
        this.name = name;
    }
}
