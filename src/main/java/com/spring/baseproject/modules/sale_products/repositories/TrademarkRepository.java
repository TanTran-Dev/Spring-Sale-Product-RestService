package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.dtos.trademark.TrademarkDto;
import com.spring.baseproject.modules.sale_products.models.entities.Trademark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface TrademarkRepository extends JpaRepository<Trademark, Integer> {
    Trademark findFirstById(Integer id);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos." +
            "trademark.TrademarkDto(trademark.id, trademark.name, trademark.imageUrl) " +
            "from Trademark trademark")
    Page<TrademarkDto> getListTrademarkDtos(Pageable pageable);

    @Query("select new com.spring.baseproject.modules.sale_products.models.dtos." +
            "trademark.TrademarkDto(trademark.id, trademark.name, trademark.imageUrl) " +
            "from Trademark trademark " +
            "where trademark.id = ?1")
    TrademarkDto getTrademarkDto(Integer id);

    @Modifying
    @Transactional
    void deleteById(Integer id);

    @Modifying
    @Transactional
    void deleteAllByIdIn(Set<Integer> ids);
}
