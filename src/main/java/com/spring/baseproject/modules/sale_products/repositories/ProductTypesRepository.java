package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.dtos.product_type.ProductTypeDto;
import com.spring.baseproject.modules.sale_products.models.entities.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface ProductTypesRepository extends JpaRepository<ProductType, Integer> {
    ProductType findFirstById(Integer id);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.product_type.ProductTypeDto(pt.id, pt.productTypeName, pt.imageUrl) " +
            "from ProductType pt")
    Page<ProductTypeDto> getPageProductTypeDtos(Pageable pageable);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.product_type.ProductTypeDto(pt.id, pt.productTypeName, pt.imageUrl) " +
            "from ProductType pt " +
            "where pt.id = ?1")
    ProductTypeDto getProductTypeDto(Integer id);

    @Query("SELECT pt.imageUrl FROM ProductType pt where pt.id = ?1")
    String getProductTypeImageUrl(Integer productTypeID);

    @Transactional
    @Modifying
    @Query("UPDATE ProductType pt SET pt.imageUrl = ?2 WHERE pt.id = ?1")
    void updateProductTypeImage(Integer id, String imageUrl);

    @Modifying
    @Transactional
    void deleteById(Integer id);

    @Modifying
    @Transactional
    void deleteAllByIdIn(Set<Integer> ids);
}
