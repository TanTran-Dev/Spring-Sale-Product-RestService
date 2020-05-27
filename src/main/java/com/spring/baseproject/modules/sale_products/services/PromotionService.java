package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.sale_products.models.dtos.promotion_type.NewPromotionTypeDto;
import com.spring.baseproject.modules.sale_products.models.dtos.promotion_type.PromotionTypeDto;
import com.spring.baseproject.modules.sale_products.models.entities.PromotionType;
import com.spring.baseproject.modules.sale_products.repositories.PromotionTypeRepository;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {
    @Autowired
    PromotionTypeRepository promotionTypeRepository;

    public BaseResponse createNewPromotionType(NewPromotionTypeDto newPromotionTypeDto) {
        PromotionType promotionType = new PromotionType(newPromotionTypeDto);
        promotionTypeRepository.save(promotionType);
        return new BaseResponse(ResponseValue.SUCCESS, promotionType);
    }

    public BaseResponse getListPromotionTypeDtos(List<String> sortBy, List<String> sortType) {
        Sort sort = SortAndPageFactory.createSort(sortBy, sortType);
        promotionTypeRepository.getListPromotionTypeDtos(sort);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse getPromotionTypeDto(Integer id) {
        PromotionTypeDto promotionTypeDto = promotionTypeRepository.getPromotionTypeDto(id);
        if (promotionTypeDto == null) {
            return new BaseResponse(ResponseValue.PROMOTION_TYPE_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, promotionTypeDto);
    }
}
