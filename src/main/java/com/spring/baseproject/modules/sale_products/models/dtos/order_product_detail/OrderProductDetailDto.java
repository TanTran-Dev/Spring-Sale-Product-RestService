package com.spring.baseproject.modules.sale_products.models.dtos.order_product_detail;

import com.spring.baseproject.modules.sale_products.models.entities.OrderProduct;
import com.spring.baseproject.modules.sale_products.models.entities.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OrderProductDetailDto {
    @ApiModelProperty(notes = "id chi tiết đơn hàng")
    private String id;

    @ApiModelProperty(notes = "Thông tin đơn hàng")
    private OrderProduct orderProduct;

    @ApiModelProperty(notes = "thông tin sản phẩm")
    private Product product;

    @ApiModelProperty(notes = "id chi tiết đơn hàng")
    private int count;


}
