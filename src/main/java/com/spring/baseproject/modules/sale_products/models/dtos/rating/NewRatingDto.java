package com.spring.baseproject.modules.sale_products.models.dtos.rating;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class NewRatingDto {
    @ApiModelProperty(notes = "nội dung bình luận", position = 1)
    private String content;

    @ApiModelProperty(notes = "số sao đánh giá", position = 2)
    private Float ratingStart;

    @ApiModelProperty(notes = "id người mua", position = 3)
    private String customerId;

    @ApiModelProperty(notes = "id sản phẩm", position = 4)
    private Integer productId;

    public NewRatingDto() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getRatingStart() {
        return ratingStart;
    }

    public void setRatingStart(Float ratingStart) {
        this.ratingStart = ratingStart;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
