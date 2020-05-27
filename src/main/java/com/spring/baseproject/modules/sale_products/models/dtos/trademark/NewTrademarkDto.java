package com.spring.baseproject.modules.sale_products.models.dtos.trademark;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class NewTrademarkDto {
    @ApiModelProperty(notes = ("tên thương hiệu"), example = "NOT_EMPTY", position = 1)
    @NotEmpty
    private String name;

    @ApiModelProperty(notes = ("ảnh thương hiệu"), position = 2)
    private String imageUrl;

    public NewTrademarkDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
