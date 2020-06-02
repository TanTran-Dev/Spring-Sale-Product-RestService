package com.spring.baseproject.modules.sale_products.models.dtos.product;

import com.spring.baseproject.modules.admin.models.dtos.AdminDto;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import com.spring.baseproject.modules.sale_products.models.dtos.product_type.ProductTypeDto;
import com.spring.baseproject.modules.sale_products.models.dtos.trademark.TrademarkDto;
import com.spring.baseproject.modules.sale_products.models.entities.ProductTypeName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ProductPreviewDto {
    @ApiModelProperty(notes = "id sản phẩm")
    private int id;

    @ApiModelProperty(notes = "tên sản phẩm")
    private String name;

    @ApiModelProperty(notes = "giá sản phẩm")
    private int price;

    @ApiModelProperty(notes = "ảnh cover sản phẩm")
    private String bigImageUrl;

    @ApiModelProperty(notes = "ảnh nhỏ sản phẩm")
    private String smallImageUrl;

    @ApiModelProperty(notes = "loại sản phẩm")
    private ProductTypeDto productType;

    @ApiModelProperty(notes = "thương hiệu sản phẩm")
    private TrademarkDto trademark;

    @ApiModelProperty(notes = "sản phẩm có đươck giảm giá ko?")
    private boolean isSale;
//
//    @ApiModelProperty(notes = "thông tin sản phẩm")
//    private String information;

    @ApiModelProperty(notes = "số lượng sản phẩm hiện có")
    private int count;

    @ApiModelProperty(notes = "ngày tạo sản phẩm")
    private Date createdDate;

    @ApiModelProperty(notes = "người bán sản phẩm")
    private AdminDto adminDto;

    public ProductPreviewDto() {
    }

    public ProductPreviewDto(Integer id, String name, Integer price, String bigImageUrl,
                      String smallImageUrl, Boolean isSale,  Integer count, Date createdDate,
                      Integer productTypeId, ProductTypeName productTypeName,
                      String adminId, String firstName, String lastName, String address, String phone, Gender gender,
                      String userId, String username, Boolean isBanned, Date lastActive,
                      Integer trademarkId, String trademarkName, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.bigImageUrl = bigImageUrl;
        this.smallImageUrl = smallImageUrl;
        this.count = count;
        this.isSale = isSale;
        this.createdDate = createdDate;
        this.productType = new ProductTypeDto(productTypeId, productTypeName);
        this.adminDto = new AdminDto(adminId, firstName, lastName, address, phone, gender,
                userId, username, isBanned, lastActive);
        this.trademark = new TrademarkDto(trademarkId, trademarkName, imageUrl);
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public ProductTypeDto getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDto productType) {
        this.productType = productType;
    }

    public TrademarkDto getTrademark() {
        return trademark;
    }

    public void setTrademark(TrademarkDto trademark) {
        this.trademark = trademark;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public AdminDto getAdminDto() {
        return adminDto;
    }

    public void setAdminDto(AdminDto adminDto) {
        this.adminDto = adminDto;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }
}
