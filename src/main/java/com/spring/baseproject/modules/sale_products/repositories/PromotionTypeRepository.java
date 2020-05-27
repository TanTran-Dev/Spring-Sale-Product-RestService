package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.dtos.promotion_type.PromotionTypeDto;
import com.spring.baseproject.modules.sale_products.models.entities.PromotionType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface PromotionTypeRepository extends JpaRepository<PromotionType, Integer> {
    PromotionType findFirstById(Integer id);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.promotion_type." +
            "PromotionTypeDto(promotionType.id, promotionType.name) " +
            "from PromotionType promotionType")
    List<PromotionTypeDto> getListPromotionTypeDtos(Sort sort);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos.promotion_type." +
            "PromotionTypeDto(promotionType.id, promotionType.name) " +
            "from PromotionType  promotionType " +
            "where promotionType.id = ?1")
    PromotionTypeDto getPromotionTypeDto(Integer id);

    @Modifying
    @Transactional
    void deleteById(Integer id);

    @Modifying
    @Transactional
    void deleteAllByIdIn(Set<Integer> ids);
}
