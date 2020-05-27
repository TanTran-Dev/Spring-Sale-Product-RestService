package com.spring.baseproject.modules.sale_products.controllers;

import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.constants.StringConstants;
import com.spring.baseproject.modules.sale_products.models.dtos.promotion_type.NewPromotionTypeDto;
import com.spring.baseproject.modules.sale_products.services.PromotionService;
import com.spring.baseproject.swagger.sale_products.promotion_type.ListPromotionTypeSwagger;
import com.spring.baseproject.swagger.sale_products.promotion_type.PromotionTypeSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/promotion-type")
@Api(description = "Loại khuyến mãi")
public class PromotionTypeController extends BaseRESTController {
    @Autowired
    PromotionService promotionService;

    @ApiOperation(value = "Tạo mới loại khuyến mãi")
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @PostMapping("/new-promotion-types")
    public BaseResponse addPromotionType(@RequestBody @Valid NewPromotionTypeDto newPromotionTypeDto) {
        return promotionService.createNewPromotionType(newPromotionTypeDto);
    }

    @ApiOperation(value = "Lấy danh sách các loại khuyến mãi")
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = ListPromotionTypeSwagger.class),
            @Response(responseValue = ResponseValue.PROMOTION_TYPE_NOT_FOUND)
    })
    @GetMapping("/promotion-types")
    public BaseResponse getListPromotionType(@RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
                                             @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType) {
        return promotionService.getListPromotionTypeDtos(sortBy, sortType);
    }

    @ApiOperation(value = "Xem thông tin loại khuyễn mãi")
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = PromotionTypeSwagger.class)
    })
    @GetMapping("/promotion-types/{id}")
    public BaseResponse getPromotionType(@PathVariable("id") Integer promotionTypeId) {
        return promotionService.getPromotionTypeDto(promotionTypeId);
    }
}
