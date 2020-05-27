package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.dtos.sale_product.SaleProductDto;
import com.spring.baseproject.modules.sale_products.models.entities.SaleProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface SaleProductRepository extends JpaRepository<SaleProduct, Integer> {
    SaleProduct findFirstById(Integer id);

//    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.promotion_product.PromotionProductDto(" +
//            "pp.id, pp.startedDate, pp.finishedDate, pp.percent, p.id, p.name, p.price, p.bigImageUrl, p.smallImageUrl, p.count, p.createdDate, p.information, " +
//            "p.productType.id, p.productType.productTypeName, p.admin.id, p.admin.firstName, p.admin.lastName,p.admin.address, p.admin.phone, p.admin.gender, " +
//            "p.admin.user.id, p.admin.user.username, p.admin.user.isBanned, p.admin.user.lastActive, " +
//            "p.trademark.id, p.trademark.name, p.trademark.imageUrl) " +
//            "from PromotionProduct pp " +
//            "left join Product p")
//    Page<PromotionProductDto> getPagePromotionProductDto(Pageable pageable);
//
//    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.promotion_product.PromotionProductDto(" +
//            "pp.id, pp.startedDate, pp.finishedDate, pp.percent, p.id, p.name, p.price, p.bigImageUrl, p.smallImageUrl, p.count, p.createdDate, p.information, " +
//            "p.productType.id, p.productType.productTypeName, p.admin.id, p.admin.firstName, p.admin.lastName,p.admin.address, p.admin.phone, p.admin.gender, " +
//            "p.admin.user.id, p.admin.user.username, p.admin.user.isBanned, p.admin.user.lastActive, " +
//            "p.trademark.id, p.trademark.name, p.trademark.imageUrl) " +
//            "from PromotionProduct pp " +
//            "left join Product p " +
//            "where pp.id = ?1")
//    PromotionProductDto getPromotionProductDto(Integer id);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.sale_product.SaleProductDto(" +
            "pp.id, pp.startedDate, pp.finishedDate, pp.percent, pp.pricePromotion, p.id) " +
            "from SaleProduct pp " +
            "left join pp.product p")
    Page<SaleProductDto> getPagePromotionProductDto(Pageable pageable);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.sale_product.SaleProductDto(" +
            "pp.id, pp.startedDate, pp.finishedDate, pp.percent, pp.pricePromotion, p.id) " +
            "from SaleProduct  pp " +
            "left join pp.product p " +
            "where pp.id = ?1")
    SaleProductDto getPromotionProductDto(Integer id);

    @Modifying
    @Transactional
    void deleteAllByIdIn(Set<Integer> ids);
}
