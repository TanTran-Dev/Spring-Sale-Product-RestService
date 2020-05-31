package com.spring.baseproject.modules.sale_products.models.entities;

import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart.NewShoppingCartDto;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public ShoppingCart() {
    }

    public ShoppingCart(NewShoppingCartDto newShoppingCartDto) {
        update(newShoppingCartDto);
    }

    public void update(NewShoppingCartDto newShoppingCartDto){
        BeanUtils.copyProperties(newShoppingCartDto,this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
