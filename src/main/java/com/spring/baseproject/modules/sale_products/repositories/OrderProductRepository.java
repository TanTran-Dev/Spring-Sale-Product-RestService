package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.entities.OrderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface OrderProductRepository extends JpaRepository<OrderProduct, String> {
    OrderProduct findFirstById(String orderId);

    @Query("select o " +
            "from OrderProduct o " +
            "left join o.product " +
            "left join o.customer " +
            "left join o.admin " +
            "left join o.shoppingCart")
    Page<OrderProduct> getPageOrderProduct(Pageable pageable);

    @Query("select o " +
            "from OrderProduct o " +
            "left join o.product " +
            "left join o.customer " +
            "left join o.admin " +
            "left join o.shoppingCart " +
            "where o.id = ?1")
    OrderProduct getOrderProduct (String orderId);

    @Modifying
    @Transactional
    void deleteAllByIdIn(Set<String> orderIDs);
}
