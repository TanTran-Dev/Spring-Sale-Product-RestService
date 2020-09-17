package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto;
import com.spring.baseproject.modules.sale_products.models.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findFirstById(Integer id);

    List<Product> findAllByIdIn(List<Integer> ids);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto(" +
            "p.id, p.name, p.price, p.count, p.createdDate, p.bigImageUrl, p.smallImageUrl, " +
            "pt.id, tm.id, s.id, p.information) " +
            "from Product p " +
            "left join p.productType pt " +
            "left join p.salesman s " +
            "left join p.trademark tm " +
            "where p.id = ?1")
    ProductDto getProductDto(Integer id);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto(" +
            "p.id, p.name, p.price, p.count, p.createdDate, p.bigImageUrl, p.smallImageUrl, " +
            "pt.id, tm.id, s.id, p.information) " +
            "from Product p " +
            "left join p.productType pt " +
            "left join p.salesman s " +
            "left join p.trademark tm " +
            "where (?1 = 0 or pt.id = ?1) and (?2 = 0 or tm.id = ?2)")
    Page<ProductDto> getPageProduct(Integer productTypeId, Integer trademarkId, Pageable pageable);

    @Query("select p " +
            "from Product p " +
            "left join p.productType pt " +
            "left join p.salesman s " +
            "left join p.trademark tm " +
            "where s.id = ?1")
    Page<Product> getPageProductBySalesman(String salesmanId, Pageable pageable);

    @Query("select p " +
            "from Product p " +
            "left join p.productType " +
            "left join p.salesman " +
            "left join p.trademark " +
            "where p.id = ?1")
    Product getProduct(Integer id);

    @Modifying
    @Transactional
    void deleteAllByIdIn(Set<Integer> ids);
}
