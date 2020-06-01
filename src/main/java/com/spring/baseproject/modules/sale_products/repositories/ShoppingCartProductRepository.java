package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product.ShoppingCartProductDto;
import com.spring.baseproject.modules.sale_products.models.entities.ShoppingCartProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, String> {
    ShoppingCartProduct findFirstById(String shoppingCartProductID);

    @Query("select s " +
            "from ShoppingCartProduct s " +
            "left join s.product " +
            "left join s.shoppingCart")
    Page<ShoppingCartProductDto> getPageShoppingCartProductDtos(Pageable pageable);

    @Query("select s " +
            "from ShoppingCartProduct s " +
            "left join s.product " +
            "left join s.shoppingCart " +
            "where s.id = ?1")
    ShoppingCartProductDto getShoppingCartProductDto(Integer productId);
}
