package com.spring.baseproject.modules.sale_products.models.dtos.order_product;

import com.spring.baseproject.modules.admin.models.dtos.AdminDto;
import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart.ShoppingCartDto;
import com.spring.baseproject.modules.sale_products.models.entities.OrderProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@ApiModel
public class OrderProductPreviewDto {
    @ApiModelProperty(notes = "id đơn hàng")
    private String id;

    @ApiModelProperty(notes = "địa chỉ nhận hàng", position = 2)
    private String deliveryAddress;

    @ApiModelProperty(notes = "ngày đặt hàng", position = 3)
    private Date orderDate;

    @ApiModelProperty(notes = "ngày nhận hàng", position = 4)
    private Date deliveryDate;

    @ApiModelProperty(notes = "thông tin người mua", position = 5)
    private CustomerDto customer;

    @ApiModelProperty(notes = "thông tin người bán", position = 6)
    private AdminDto admin;

    @ApiModelProperty(notes = "thông tin giỏ hàng", position = 7)
    private ShoppingCartDto shoppingCart;

    public OrderProductPreviewDto() {
    }

    public OrderProductPreviewDto(CustomerDto customerDto, AdminDto adminDto, ShoppingCartDto shoppingCartDto, OrderProduct orderProduct) {
        this.customer = customerDto;
        this.admin = adminDto;
        this.shoppingCart = shoppingCartDto;
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

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public AdminDto getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDto admin) {
        this.admin = admin;
    }

    public ShoppingCartDto getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartDto shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
