package com.spring.baseproject.modules.sale_products.models.dtos.product_type;

import com.spring.baseproject.modules.sale_products.models.entities.ProductType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;


@ApiModel
public class ProductTypeDto {
    @ApiModelProperty(notes = ("id loại sản phẩm"))
    private int id;

    @ApiModelProperty(notes = ("tên loại sản phẩm"))
    private String name;

    public ProductTypeDto() {
    }

    public ProductTypeDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductTypeDto(ProductType productType) {
        BeanUtils.copyProperties(productType, this);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
