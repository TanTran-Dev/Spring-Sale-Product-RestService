package com.spring.baseproject.modules.sale_products.models.dtos.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class NewProductDto {
    @ApiModelProperty(notes = "Tên sản phẩm", example = "NOT_EMPTY", position = 1)
    private String name;

    @ApiModelProperty(notes = "giá thành sản phẩm", position = 2)
    private Integer price;

    @ApiModelProperty(notes = "ảnh cover sản phẩm", position = 3)
    private String bigImageUrl;

    @ApiModelProperty(notes = "ảnh logo sản phẩm", position = 4)
    private String smallImageUrl;

    @ApiModelProperty(notes = "số lượng sản phẩm hiện có", position = 5)
    private Integer count;

    @ApiModelProperty(notes = "id admin", example = "NOT_EMPTY", position = 6)
    private String adminId;

    @ApiModelProperty(notes = "id loại sản phẩm", example = "NOT_EMPTY", position = 7)
    private Integer productTypeId;

    @ApiModelProperty(notes = "id thương hiệu", example = "NOT_EMPTY", position = 8)
    private Integer trademarkId;

    @ApiModelProperty(notes = "sản phẩm có được giảm giá ko?", example = "False", position = 9)
    private Boolean isSale = false;

    @ApiModelProperty(notes = "thông tin chi tiết sản phẩm", position = 10)
    private String information;
    public NewProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBigImageUrl() {
        return bigImageUrl;
    }

    public void setBigImageUrl(String bigImageUrl) {
        this.bigImageUrl = bigImageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Integer getTrademarkId() {
        return trademarkId;
    }

    public void setTrademarkId(Integer trademarkId) {
        this.trademarkId = trademarkId;
    }

    public Boolean getSale() {
        return isSale;
    }

    public void setSale(Boolean sale) {
        isSale = sale;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
