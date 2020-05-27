package com.spring.baseproject.modules.sale_products.models.entities;

import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.sale_products.models.dtos.product.NewProductDto;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "big_image_url")
    private String bigImageUrl;

    @Column(name = "small_image_url")
    private String smallImageUrl;

    @Column(name = "information")
    private String information;

    @Column(name = "count")
    private int count;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "is_sale")
    private boolean isSale = false;

    @ManyToOne(
            fetch = FetchType.LAZY// always using LAZY fetching strategy
    )
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne(
            fetch = FetchType.LAZY// always using LAZY fetching strategy
    )
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "trademark_id")
    private Trademark trademark;

    @PrePersist
    public void onPrePersist() {
        this.createdDate = new Date();
    }

    public Product() {

    }

    public Product(Admin admin, ProductType productType, Trademark trademark, NewProductDto newProductDto) {
        update(admin, productType, trademark, newProductDto);
    }

    public void update(Admin admin, ProductType productType, Trademark trademark, NewProductDto newProductDto) {
        this.admin = admin;
        this.productType = productType;
        this.trademark = trademark;
        BeanUtils.copyProperties(newProductDto, this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBigImageUrl() {
        return bigImageUrl;
    }

    public void setBigImageUrl(String bigImageUrl) {
        this.bigImageUrl = bigImageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Trademark getTrademark() {
        return trademark;
    }

    public void setTrademark(Trademark trademark) {
        this.trademark = trademark;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }
}
