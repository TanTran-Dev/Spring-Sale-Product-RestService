package com.spring.baseproject.modules.sale_products.models.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_product_detail")
public class OrderProductDetail {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "order_product_id")
    private OrderProduct orderProduct;

    @OneToMany(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "product_id")
    private List<Product> products;

    @Column(name = "count")
    private int count;

    public OrderProductDetail() {
    }

    public void update(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
