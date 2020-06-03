package com.spring.baseproject.modules.sale_products.models.entities;

import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.sale_products.models.dtos.order_product.NewOrderProductDto;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "description")
    private String description;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @PrePersist
    public void onPrePersist() {
        this.orderDate = new Date();
    }

    public OrderProduct() {
    }

    public OrderProduct(Customer customer, Admin admin, ShoppingCart shoppingCart, NewOrderProductDto newOrderProductDto) {
        this.customer = customer;
        this.admin = admin;
        this.shoppingCart = shoppingCart;
        update(newOrderProductDto);
    }

    public void update(NewOrderProductDto newOrderProductDto) {
        BeanUtils.copyProperties(newOrderProductDto, this);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
