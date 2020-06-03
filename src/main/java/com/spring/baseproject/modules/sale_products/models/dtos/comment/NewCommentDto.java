package com.spring.baseproject.modules.sale_products.models.dtos.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class NewCommentDto {
    @ApiModelProperty(notes = "nội dung bình luận", position = 1)
    private String content;

    @ApiModelProperty(notes = "id người mua", position = 2)
    private String customerId;

    @ApiModelProperty(notes = "id sản phẩm", position = 3)
    private Integer productId;

    public NewCommentDto() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
