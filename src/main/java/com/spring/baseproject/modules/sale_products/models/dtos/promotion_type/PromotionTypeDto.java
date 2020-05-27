package com.spring.baseproject.modules.sale_products.models.dtos.promotion_type;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class PromotionTypeDto {
    @ApiModelProperty(notes = "id loại khuyến mãi")
    private int id;

    @ApiModelProperty(notes = "tên loại khuyến mãi")
    private String name;

    public PromotionTypeDto() {
    }

    public PromotionTypeDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
