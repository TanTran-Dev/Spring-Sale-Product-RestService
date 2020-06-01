package com.spring.baseproject.modules.sale_products.models.entities;

import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product.NewShoppingCartProductDto;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart_product")
public class ShoppingCartProduct {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id")
    private String id;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @Column(name = "count")
    private int count;

    public ShoppingCartProduct() {

    }


    public ShoppingCartProduct(NewShoppingCartProductDto newShoppingCartProductDto){
        update(newShoppingCartProductDto);
    }

    public void update(NewShoppingCartProductDto newShoppingCartProductDto){
        BeanUtils.copyProperties(newShoppingCartProductDto, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
