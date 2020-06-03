package com.spring.baseproject.modules.sale_products.models.dtos.order_product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class NewOrderProductDto {
    @ApiModelProperty(notes = "địa chỉ nhận hàng", position = 1)
    private String deliveryAddress;

    @ApiModelProperty(notes = "thời gian đặt hàng", position = 2)
    private Date orderDate;

    @ApiModelProperty(notes = "thời gian nhận hàng", position = 3)
    private Date deliveryDate;

    @ApiModelProperty(notes = "nội dung đơn hàng", position = 4)
    private String description;

    @ApiModelProperty(notes = "id người mua", position = 5)
    private String customerId;

    @ApiModelProperty(notes = "id người bán", position = 6)
    private String adminId;

    @ApiModelProperty(notes = "id giỏ hàng", position = 7)
    private String shoppingCartId;

    public NewOrderProductDto() {
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }
}
