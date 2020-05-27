package com.spring.baseproject.modules.sale_products.models.dtos.promotion_type;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class NewPromotionTypeDto {
    @ApiModelProperty(notes = "tên loại khuyễn mãi", position = 1)
    private String name;

    public NewPromotionTypeDto(String name) {
        this.name = name;
    }

    public NewPromotionTypeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
