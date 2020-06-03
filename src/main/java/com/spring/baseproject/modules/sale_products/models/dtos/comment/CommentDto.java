package com.spring.baseproject.modules.sale_products.models.dtos.comment;

import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto;
import com.spring.baseproject.modules.sale_products.models.entities.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@ApiModel
public class CommentDto {
    @ApiModelProperty(notes = "id bình luận")
    private String id;

    @ApiModelProperty(notes = "nội dung bình luận", position = 1)
    private String content;

    @ApiModelProperty(notes = "thời gian bình luận", position = 2)
    private Date commentDate;

    @ApiModelProperty(notes = "thông tin người mua", position = 3)
    private CustomerDto customerDto;

    @ApiModelProperty(notes = "thông tin sản phẩm", position = 4)
    private ProductDto productDto;

    public CommentDto() {
    }

    public CommentDto(CustomerDto customerDto, ProductDto productDto, Comment comment) {
        this.customerDto = customerDto;
        this.productDto = productDto;
        this.commentDate = comment.getCommnentDate();
        BeanUtils.copyProperties(comment, this);
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

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
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
