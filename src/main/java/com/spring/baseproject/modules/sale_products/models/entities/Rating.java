package com.spring.baseproject.modules.sale_products.models.entities;

import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.sale_products.models.dtos.rating.NewRatingDto;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "content")
    private String content;

    @Column(name = "rating_star")
    private Float ratingStar;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "product_id")
    private Product product;

    public Rating() {
    }

    public Rating(Customer customer, Product product, NewRatingDto newRatingDto){
        this.customer = customer;
        this.product = product;
        this.ratingStar = newRatingDto.getRatingStart();
        update(newRatingDto);
    }

    public void update(NewRatingDto newRatingDto){
        BeanUtils.copyProperties(newRatingDto, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(Float ratingStar) {
        this.ratingStar = ratingStar;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
