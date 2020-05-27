package com.spring.baseproject.modules.sale_products.models.entities;

import com.spring.baseproject.modules.sale_products.models.dtos.sale_product.NewSaleProductDto;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sale_product")
public class SaleProduct {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "started_date")
    private Date startedDate;

    @Column(name = "finished_date")
    private Date finishedDate;

    @Column(name = "percent")
    private float percent;

    @Column(name = "price_promotion")
    private int pricePromotion;

    @OneToOne(
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JoinColumn(name = "product_id")
    private Product product;

    public SaleProduct() {
    }

    public SaleProduct(Product product, NewSaleProductDto newSaleProductDto) {
        update(product, newSaleProductDto);
    }

    public void update(Product product, NewSaleProductDto newSaleProductDto) {
        this.product = product;
        BeanUtils.copyProperties(newSaleProductDto, this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPricePromotion() {
        return pricePromotion;
    }

    public void setPricePromotion(int pricePromotion) {
        this.pricePromotion = pricePromotion;
    }
}
