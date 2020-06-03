package com.spring.baseproject.modules.sale_products.models.entities;

import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.sale_products.models.dtos.comment.NewCommentDto;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(name = "content")
    private String content;

    @Column(name = "comment_date")
    private Date commnentDate;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "product_id")
    private Product product;

    @PrePersist
    public void onPrePersist() {
        this.commnentDate = new Date();
    }

    public Comment() {
    }

    public Comment(Customer customer, Product product, NewCommentDto newCommentDto) {
        this.customer = customer;
        this.product = product;
        update(newCommentDto);
    }

    public void update(NewCommentDto newCommentDto){
        BeanUtils.copyProperties(newCommentDto, this);
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

    public Date getCommnentDate() {
        return commnentDate;
    }

    public void setCommnentDate(Date commnentDate) {
        this.commnentDate = commnentDate;
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
