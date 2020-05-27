package com.spring.baseproject.modules.sale_products.models.dtos.sale_product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class SaleProductDto {
    @ApiModelProperty(notes = "id sản phẩm khuyến mãi")
    private int id;

    @ApiModelProperty(notes = "ngày bắt đầu khuyến mãi", position = 1)
    private Date startedDate;

    @ApiModelProperty(notes = "ngày kết thúc khuyến mãi", position = 2)
    private Date finishedDate;

    @ApiModelProperty(notes = "tỉ lệ khuyến mãi", position = 3)
    private float percent;

    @ApiModelProperty(notes = "giá sản phẩm sau khi giảm giá", position = 4)
    private int pricePromotion;

    @ApiModelProperty(notes = "id sản phẩm được khuyến mãi", position = 5)
    private int productId;

    public SaleProductDto() {
    }

//    public PromotionProductDto(Integer id, Date startedDate, Date finishedDate, Float percent,
//                               Integer productId, String name, Integer price, String bigImageUrl,
//                               String smallImageUrl, Integer count, Date createdDate, String information,
//                               Integer productTypeId, ProductTypeName productTypeName,
//                               String adminId, String firstName, String lastName, String address, String phone, Gender gender,
//                               String userId, String username, Boolean isBanned, Date lastActive,
//                               Integer trademarkId, String trademarkName, String imageUrl) {
//        this.id = id;
//        this.startedDate = startedDate;
//        this.finishedDate = finishedDate;
//        this.percent = percent;
//        this.productDto = new ProductDto(productId, name, price, bigImageUrl, smallImageUrl,
//                count, createdDate, information, productTypeId, productTypeName,
//                adminId, firstName, lastName, address, phone, gender, userId, username, isBanned, lastActive,
//                trademarkId, trademarkName, imageUrl);
//    }


    public SaleProductDto(Integer id, Date startedDate, Date finishedDate, Float percent, Integer pricePromotion, Integer productId) {
        this.id = id;
        this.startedDate = startedDate;
        this.finishedDate = finishedDate;
        this.percent = percent;
        this.pricePromotion = pricePromotion;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
