package com.spring.baseproject.modules.sale_products.models.dtos.sale_product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class NewSaleProductDto {
    @ApiModelProperty(notes = "ngày bắt đầu khuyến mãi", position = 1)
    private Date startedDate;

    @ApiModelProperty(notes = "ngày kết thúc khuyến mãi", position = 2)
    private Date finishedDate;

    @ApiModelProperty(notes = "tỉ lệ khuyến mãi", position = 3)
    private float percent;

    @ApiModelProperty(notes = "giá sản phẩm sau khi giảm giá", position = 4)
    private int pricePromotion;

    @ApiModelProperty(notes = "id sản phẩm khuyến mãi", position = 5)
    private int productId;

    public NewSaleProductDto() {
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPricePromotion() {
        return pricePromotion;
    }

    public void setPricePromotion(int pricePromotion) {
        this.pricePromotion = pricePromotion;
    }
}
