package com.spring.baseproject.modules.sale_products.models.dtos.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.baseproject.modules.sale_products.models.entities.Product;
import com.spring.baseproject.modules.salesman.models.dtos.SalesmanDto;
import com.spring.baseproject.modules.salesman.models.entities.Salesman;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@ApiModel
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @ApiModelProperty(notes = "id sản phẩm")
    private int id;

    @ApiModelProperty(notes = "tên sản phẩm", position = 1)
    private String name;

    @ApiModelProperty(notes = "giá sản phẩm", position = 2)
    private int price;

    @ApiModelProperty(notes = "số lượng sản phẩm hiện có", position = 3)
    private int count;

    @ApiModelProperty(notes = "ngày tạo sản phẩm", position = 4)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdDate;

    @ApiModelProperty(notes = "ảnh cover sản phẩm", position = 5)
    private String bigImageUrl;

    @ApiModelProperty(notes = "ảnh nhỏ sản phẩm", position = 6)
    private String smallImageUrl;

    @ApiModelProperty(notes = "loại sản phẩm", position = 7)
    private Integer productTypeID;

    @ApiModelProperty(notes = "thương hiệu sản phẩm", position = 8)
    private Integer trademarkID;

    @ApiModelProperty(notes = "người bán sản phẩm", position = 9)
    private SalesmanDto salesmanDto;

    @ApiModelProperty(notes = "thông tin sản phẩm", position = 10)
    private String information;


    public ProductDto(Product product) {
        BeanUtils.copyProperties(product, this);
    }

    public ProductDto(
            int id, String name, int price, int count, Date createdDate, String bigImageUrl, String smallImageUrl,
            Integer productTypeID, Integer trademarkID,
            String salesmanID, String firstName, String lastName, String phone, String contactEmail, String avatarUrl, String imageCoverUrl,
            String information) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.createdDate = createdDate;
        this.bigImageUrl = bigImageUrl;
        this.smallImageUrl = smallImageUrl;
        this.productTypeID = productTypeID;
        this.trademarkID = trademarkID;
        this.salesmanDto = new SalesmanDto(salesmanID, firstName, lastName, phone, contactEmail, avatarUrl, imageCoverUrl);
        this.information = information;
    }
}
