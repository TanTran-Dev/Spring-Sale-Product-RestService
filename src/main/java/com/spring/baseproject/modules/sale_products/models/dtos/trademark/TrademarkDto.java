package com.spring.baseproject.modules.sale_products.models.dtos.trademark;

import com.spring.baseproject.modules.sale_products.models.entities.Trademark;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

@ApiModel
public class TrademarkDto {
    @ApiModelProperty(notes = "id thương hiệu")
    private int id;

    @ApiModelProperty(notes = ("tên thương hiệu"))
    private String name;

    @ApiModelProperty(notes = ("hình ảnh thương hiệu"))
    private String imageUrl;

    public TrademarkDto() {
    }

    public TrademarkDto(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public TrademarkDto(Trademark trademark) {
        BeanUtils.copyProperties(trademark, this);
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
