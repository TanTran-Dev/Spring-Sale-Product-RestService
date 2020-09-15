package com.spring.baseproject.modules.sale_products.models.dtos.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.sale_products.models.entities.Comment;
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
public class CommentDto {
    @ApiModelProperty(notes = "id bình luận")
    private String id;

    @ApiModelProperty(notes = "nội dung bình luận", position = 1)
    private String content;

    @ApiModelProperty(notes = "thời gian bình luận", position = 2)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdDate;

    @ApiModelProperty(notes = "thông tin sản phẩm", position = 3)
    private Integer productID;

    @ApiModelProperty(notes = "thông tin người mua", position = 4)
    private CustomerDto customerDto;

    public CommentDto(Comment comment, Customer customer) {
        BeanUtils.copyProperties(comment, this);
        this.customerDto = new CustomerDto(customer);
        this.productID = comment.getProduct().getId();
    }
}
