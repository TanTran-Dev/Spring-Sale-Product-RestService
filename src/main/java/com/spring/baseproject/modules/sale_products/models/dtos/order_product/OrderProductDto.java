package com.spring.baseproject.modules.sale_products.models.dtos.order_product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.baseproject.modules.salesman.models.entities.Salesman;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.sale_products.models.entities.OrderProduct;
import com.spring.baseproject.modules.sale_products.models.entities.Product;
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
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date orderDate;

    @ApiModelProperty(notes = "ngày nhận hàng", position = 4)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date deliveryDate;

    @ApiModelProperty(notes = "nội dung đơn hàng", position = 5)
    private String description;

    @ApiModelProperty(notes = "thông tin sản phẩm", position = 6)
    private Product product;

    @ApiModelProperty(notes = "số lượng sản phẩm có trong đơn hàng", position = 7)
    private int count;

    @ApiModelProperty(notes = "thông tin người mua", position = 8)
    private Customer customer;

    @ApiModelProperty(notes = "thông tin người bán", position = 9)
    private Salesman salesman;

    @ApiModelProperty(notes = "thông tin giỏ hàng", position = 10)
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

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
