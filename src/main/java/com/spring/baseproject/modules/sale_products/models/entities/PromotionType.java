package com.spring.baseproject.modules.sale_products.models.entities;

import com.spring.baseproject.modules.sale_products.models.dtos.promotion_type.NewPromotionTypeDto;

import javax.persistence.*;

@Entity
@Table(name = ("promotion_type"))
public class PromotionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "name")
    private String name;

    public PromotionType() {
    }

    public PromotionType(NewPromotionTypeDto newPromotionTypeDto) {
        update(newPromotionTypeDto);
    }

    public void update(NewPromotionTypeDto newPromotionTypeDto){
        this.name = newPromotionTypeDto.getName();
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
}
