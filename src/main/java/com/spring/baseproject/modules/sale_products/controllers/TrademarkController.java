package com.spring.baseproject.modules.sale_products.controllers;

import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.constants.StringConstants;
import com.spring.baseproject.modules.sale_products.models.dtos.trademark.NewTrademarkDto;
import com.spring.baseproject.modules.sale_products.services.TrademarkService;
import com.spring.baseproject.swagger.sale_products.trademark.ListTrademarkDtosSwagger;
import com.spring.baseproject.swagger.sale_products.trademark.TrademarkDtoSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/trademark")
@Api(description = "Thương hiệu sản phẩm")
public class TrademarkController extends BaseRESTController {
    @Autowired
    TrademarkService trademarkService;

    @ApiOperation(value = "Tạo mới thương hiệu")
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponse.class)
    })
    @PostMapping("/new-trademark")
    public BaseResponse createNewTrademark(@RequestBody @Valid NewTrademarkDto newTrademarkDto) {
        return trademarkService.createNewTrademark(newTrademarkDto);
    }

    @ApiOperation(value = "Lấy danh sách thương hiệu")
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = ListTrademarkDtosSwagger.class),
            @Response(responseValue = ResponseValue.TRADEMARK_NOT_FOUND)
    })
    @GetMapping("/trademarks")
    public BaseResponse getListTrademarks(@RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
                                          @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType) {
        return trademarkService.getListTrademarkDtos(sortBy, sortType);
    }

    @ApiOperation(value = "Xem thông tin thương hiệu")
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = TrademarkDtoSwagger.class)
    })
    @GetMapping("/trademark/{trademarkId}")
    public BaseResponse getTrademark(@PathVariable("trademarkId") Integer trademarkId) {
        return trademarkService.getTrademarkDto(trademarkId);
    }
}
