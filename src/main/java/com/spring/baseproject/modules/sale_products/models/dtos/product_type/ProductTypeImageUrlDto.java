package com.spring.baseproject.modules.sale_products.models.dtos.product_type;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductTypeImageUrlDto {
    @ApiModelProperty(notes = "url Product Type")
    private String imageUrl;
}
