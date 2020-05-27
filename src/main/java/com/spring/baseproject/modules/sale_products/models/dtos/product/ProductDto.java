package com.spring.baseproject.modules.sale_products.models.dtos.product;

import com.spring.baseproject.modules.admin.models.dtos.AdminDto;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import com.spring.baseproject.modules.sale_products.models.dtos.product_type.ProductTypeDto;
import com.spring.baseproject.modules.sale_products.models.dtos.trademark.TrademarkDto;
import com.spring.baseproject.modules.sale_products.models.entities.ProductTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class ProductDto {
    @ApiModelProperty(notes = "id sản phẩm")
    private int id;

    @ApiModelProperty(notes = "tên sản phẩm", position = 1)
    private String name;

    @ApiModelProperty(notes = "giá sản phẩm", position = 2)
    private int price;

    @ApiModelProperty(notes = "số lượng sản phẩm", position = 3)
    private int count;

    @ApiModelProperty(notes = "ngày tạo sản phẩm", position = 4)
    private Date createdDate;

    @ApiModelProperty(notes = "ảnh cover sản phẩm", position = 5)
    private String bigImageUrl;

    @ApiModelProperty(notes = "ảnh nhỏ sản phẩm", position = 6)
    private String smallImageUrl;

    @ApiModelProperty(notes = "sản phẩm có được giảm giá ko?", example = "True, False", position = 7)
    private Boolean isSale;

    @ApiModelProperty(notes = "loại sản phẩm", position = 8)
    private ProductTypeDto productType;

    @ApiModelProperty(notes = "thương hiệu sản phẩm", position = 9)
    private TrademarkDto trademark;

    @ApiModelProperty(notes = "người bán sản phẩm", position = 10)
    private AdminDto adminDto;

    @ApiModelProperty(notes = "thông tin sản phẩm", position = 11)
    private String information;


    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Integer price, String bigImageUrl,
                      String smallImageUrl, Boolean isSale, Integer count, Date createdDate, String information,
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
        this.information = information;
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

//    public String getInformation() {
//        return information;
//    }
//
//    public void setInformation(String information) {
//        this.information = information;
//    }

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

    public AdminDto getAdminDto() {
        return adminDto;
    }

    public void setAdminDto(AdminDto adminDto) {
        this.adminDto = adminDto;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Boolean getSale() {
        return isSale;
    }

    public void setSale(Boolean sale) {
        isSale = sale;
    }
}
