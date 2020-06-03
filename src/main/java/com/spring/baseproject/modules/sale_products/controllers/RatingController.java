package com.spring.baseproject.modules.sale_products.controllers;

import com.spring.baseproject.annotations.auth.AuthorizationRequired;
import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.sale_products.models.dtos.rating.NewRatingDto;
import com.spring.baseproject.modules.sale_products.services.RatingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/rating")
@Api(description = "Đánh giá về sản phẩm")
public class RatingController extends BaseRESTController {
    @Autowired
    private RatingService ratingService;

    @ApiOperation(value = "Tạo mới một đánh giá", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @AuthorizationRequired
    @PostMapping("/new-rating")
    public BaseResponse addOrderProduct(@RequestBody @Valid NewRatingDto newRatingDto) {
        return ratingService.createNewRating(newRatingDto);
    }

    @ApiOperation(value = "Chỉnh sửa đánh giá", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.RATING_NOT_FOUND)
    })
    @AuthorizationRequired
    @PutMapping("/ratings/{id}")
    public BaseResponse updateProduct(@PathVariable("id") String ratingId,
                                      @RequestParam("content") String content,
                                      @RequestParam("rating_star") Float ratingStar) {
        return ratingService.updateRating(ratingId, content, ratingStar);
    }
}
