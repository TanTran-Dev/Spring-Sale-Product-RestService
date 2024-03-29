package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.sale_products.models.dtos.trademark.NewTrademarkDto;
import com.spring.baseproject.modules.sale_products.models.dtos.trademark.TrademarkDto;
import com.spring.baseproject.modules.sale_products.models.entities.Trademark;
import com.spring.baseproject.modules.sale_products.repositories.TrademarkRepository;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrademarkService {
    @Autowired
    TrademarkRepository trademarkRepository;

    public BaseResponse createNewTrademark(NewTrademarkDto newTrademarkDto) {
        Trademark trademark = new Trademark(newTrademarkDto);
        trademarkRepository.save(trademark);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse getListTrademarkDtos(List<String> sortBy, List<String> sortType, int pageIndex, int pageSize) {
        Pageable pageable = SortAndPageFactory.createPageable(sortBy, sortType, pageIndex, pageSize, NumberConstants.MAX_PAGE_SIZE);
        Page<TrademarkDto> trademarkDtos = trademarkRepository.getListTrademarkDtos(pageable);
        return new BaseResponse(ResponseValue.SUCCESS, trademarkDtos);
    }

    public BaseResponse getTrademarkDto(Integer trademarkId) {
        TrademarkDto trademarkDto = trademarkRepository.getTrademarkDto(trademarkId);
        if (trademarkDto == null) {
            return new BaseResponse(ResponseValue.TRADEMARK_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, trademarkDto);
    }
}
