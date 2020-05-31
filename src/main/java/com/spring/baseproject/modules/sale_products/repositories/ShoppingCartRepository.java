package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart.ShoppingCartDto;
import com.spring.baseproject.modules.sale_products.models.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
    ShoppingCart findFirstById(Integer id);
    ShoppingCart findFirstByCustomerId(String customerId);
//    @Query("select s " +
//            "from ShoppingCart s " +
//            "left join s.products")
//    Page<ShoppingCart> getPageShoppingCartDto(Pageable pageable);
//
//    @Query("select s " +
//            "from ShoppingCart s " +
//            "left join s.products " +
//            "where s.id = ?1")
//    ShoppingCart getShoppingCart(Integer id);

    @Query("select sc " +
            "from ShoppingCart sc " +
            "left join sc.customer c " +
            "left join c.user u " +
            "where c.id = ?1")
    ShoppingCartDto getShoppingCart(String customerId);
}
