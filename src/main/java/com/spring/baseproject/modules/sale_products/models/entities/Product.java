package com.spring.baseproject.modules.sale_products.models.entities;

import com.spring.baseproject.modules.salesman.models.entities.Salesman;
import com.spring.baseproject.modules.sale_products.models.dtos.product.NewProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "salesman_id")
    private Salesman salesman;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "trademark_id")
    private Trademark trademark;

    @PrePersist
    public void onPrePersist() {
        this.createdDate = new Date();
    }

    public Product(Salesman salesman, ProductType productType, Trademark trademark, NewProductDto newProductDto) {
        update(salesman, productType, trademark, newProductDto);
    }

    public void update(Salesman salesman, ProductType productType, Trademark trademark, NewProductDto newProductDto) {
        this.salesman = salesman;
        this.productType = productType;
        this.trademark = trademark;
        BeanUtils.copyProperties(newProductDto, this);
    }
}
