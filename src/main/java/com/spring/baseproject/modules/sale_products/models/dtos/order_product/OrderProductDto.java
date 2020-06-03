package com.spring.baseproject.modules.sale_products.models.dtos.order_product;

import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.sale_products.models.entities.OrderProduct;
import com.spring.baseproject.modules.sale_products.models.entities.ShoppingCart;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@ApiModel
public class OrderProductDto {
    @ApiModelProperty(notes = "id đơn hàng")
    private String id;

    @ApiModelProperty(notes = "địa chỉ nhận hàng", position = 2)
    private String deliveryAddress;

    @ApiModelProperty(notes = "ngày đặt hàng", position = 3)
    private Date orderDate;

    @ApiModelProperty(notes = "ngày nhận hàng", position = 4)
    private Date deliveryDate;

    @ApiModelProperty(notes = "nội dung đơn hàng", position = 5)
    private String description;

    @ApiModelProperty(notes = "thông tin người mua", position = 6)
    private Customer customer;

    @ApiModelProperty(notes = "thông tin người bán", position = 7)
    private Admin admin;

    @ApiModelProperty(notes = "thông tin giỏ hàng", position = 8)
    private ShoppingCart shoppingCart;

    public OrderProductDto() {
    }

    public OrderProductDto(OrderProduct orderProduct) {
        BeanUtils.copyProperties(orderProduct, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
