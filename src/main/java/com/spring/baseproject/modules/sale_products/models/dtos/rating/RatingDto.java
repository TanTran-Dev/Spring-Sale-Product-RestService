package com.spring.baseproject.modules.sale_products.models.dtos.rating;

import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto;
import com.spring.baseproject.modules.sale_products.models.entities.Comment;
import com.spring.baseproject.modules.sale_products.models.entities.Rating;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;


@ApiModel
public class RatingDto {
    @ApiModelProperty(notes = "id đánh giá")
    private String id;

    @ApiModelProperty(notes = "nội dung đánh giá", position = 1)
    private String content;

    @ApiModelProperty(notes = "số sao đánh giá", position = 2)
    private Float rating_star;

    @ApiModelProperty(notes = "thông tin người mua", position = 3)
    private CustomerDto customerDto;

    @ApiModelProperty(notes = "thông tin sản phẩm", position = 4)
    private ProductDto productDto;

    public RatingDto() {
    }

    public RatingDto(CustomerDto customerDto, ProductDto productDto, Rating rating){
        this.customerDto = customerDto;
        this.productDto = productDto;
        this.rating_star = rating.getRatingStar();
        BeanUtils.copyProperties(rating, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getRating_star() {
        return rating_star;
    }

    public void setRating_star(Float rating_star) {
        this.rating_star = rating_star;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
