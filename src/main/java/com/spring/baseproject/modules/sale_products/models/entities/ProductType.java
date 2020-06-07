package com.spring.baseproject.modules.sale_products.models.entities;

import com.spring.baseproject.modules.sale_products.models.dtos.product_type.NewProductTypeDto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String productTypeName;

    public ProductType() {
    }

    public ProductType(NewProductTypeDto newProductTypeDto) {
        update(newProductTypeDto);
    }

    public void update(NewProductTypeDto newProductTypeDto){
        this.productTypeName = newProductTypeDto.getProductTypeName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
