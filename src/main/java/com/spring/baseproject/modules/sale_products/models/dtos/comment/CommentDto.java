package com.spring.baseproject.modules.sale_products.models.dtos.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Date commentDate;

    @ApiModelProperty(notes = "thông tin người mua", position = 3)
    private String customerID;

    @ApiModelProperty(notes = "thông tin sản phẩm", position = 4)
    private Integer productID;
}
