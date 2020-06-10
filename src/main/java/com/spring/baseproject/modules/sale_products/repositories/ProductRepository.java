package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductPreviewDto;
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

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.product.ProductPreviewDto(" +
            "p.id, p.name, p.price,p.bigImageUrl,p.smallImageUrl,p.isSale, p.count, p.createdDate, " +
            "pt.id, pt.productTypeName, " +
            "a.id,a.firstName,a.lastName, a.address, a.birthDay, a.phone, a.gender, " +
            "a.user.id, a.user.username, a.user.isBanned,a.user.lastActive, " +
            "t.id, t.name, t.imageUrl) " +
            "from Product p " +
            "left join p.productType pt " +
            "left join p.admin a " +
            "left join p.trademark t")
    Page<ProductPreviewDto> getPageProductPreviewDto(Pageable pageable);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto(" +
            "p.id, p.name, p.price,p.bigImageUrl,p.smallImageUrl,p.isSale, p.count, p.createdDate, p.information, " +
            "pt.id, pt.productTypeName, " +
            "a.id,a.firstName,a.lastName, a.address, a. birthDay, a.phone, a.gender, " +
            "a.user.id, a.user.username, a.user.isBanned,a.user.lastActive, " +
            "t.id, t.name, t.imageUrl) " +
            "from Product p " +
            "left join p.productType pt " +
            "left join p.admin a " +
            "left join p.trademark t " +
            "where p.id = ?1")
    ProductDto getProductDto(Integer id);

    @Query("select p " +
            "from Product p " +
            "left join p.productType pt " +
            "left join p.admin " +
            "left join p.trademark tm " +
            "where (?1 = 0 or pt.id = ?1) and (?2 = 0 or tm.id = ?2)")
    Page<Product> getPageProduct(Integer productTypeId, Integer trademarkId, Pageable pageable);


    @Query("select p " +
            "from Product p " +
            "left join p.productType " +
            "left join p.admin " +
            "left join p.trademark " +
            "where p.id = ?1")
    Product getProduct(Integer id);

    @Modifying
    @Transactional
    void deleteAllByIdIn(Set<Integer> ids);
}
