package com.spring.baseproject.modules.sale_products.controllers;

import com.spring.baseproject.annotations.auth.AuthorizationRequired;
import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.constants.StringConstants;
import com.spring.baseproject.modules.sale_products.models.dtos.sale_product.NewSaleProductDto;
import com.spring.baseproject.modules.sale_products.services.SaleProductService;
import com.spring.baseproject.swagger.sale_products.promotion_product.PagePromotionProductSwagger;
import com.spring.baseproject.swagger.sale_products.promotion_product.PromotionProductDtoSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/promotion-product/")
@Api(description = "Sản phẩm khuyến mãi")
public class SaleProductController extends BaseRESTController {

    @Autowired
    private SaleProductService saleProductService;

    @ApiOperation(value = "Tạo mới một sản phẩm khuyến mãi", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @AuthorizationRequired
    @PostMapping("/new-promotion-product")
    public BaseResponse addNewPromotionProduct(@RequestBody @Valid NewSaleProductDto newSaleProductDto) {
        return saleProductService.createNewSaleProduct(newSaleProductDto);
    }

    @ApiOperation(value = "Lấy danh sách các sản phẩm khuyến mãi", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = PagePromotionProductSwagger.class),
            @Response(responseValue = ResponseValue.PROMOTION_PRODUCT_NOT_FOUND)
    })
    @GetMapping("/promotion-products")
    public BaseResponse getPagePromotionProducts(@RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
                                                 @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType,
                                                 @RequestParam(value = StringConstants.PAGE_INDEX, defaultValue = "0") int pageIndex,
                                                 @RequestParam(value = StringConstants.PAGE_SIZE, defaultValue = NumberConstants.MAX_PAGE_SIZE + "") int pageSize) {
        return saleProductService.getPageSaleProductDtos(sortBy, sortType, pageIndex, pageSize);
    }


    @ApiOperation(value = "Lấy ra thông tin chi tiết sản phẩm khuyến mãi", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = PromotionProductDtoSwagger.class),
            @Response(responseValue = ResponseValue.PROMOTION_PRODUCT_NOT_FOUND)
    })
    @GetMapping("/promotion-products/{id}")
    public BaseResponse getPromotionProduct(@PathVariable("id") Integer id) {
        return saleProductService.getSaleProductDto(id);
    }

    @ApiOperation(value = "Cập nhật thông tin sản phẩm khuyến mãi", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.PROMOTION_PRODUCT_NOT_FOUND)
    })
    @AuthorizationRequired
    @PutMapping("/promotion-products/{id}")
    public BaseResponse updatePromotionProduct(@PathVariable("id") Integer id,
                                               @RequestBody @Valid NewSaleProductDto newSaleProductDto) {
        return saleProductService.updateSaleProduct(id, newSaleProductDto);
    }

    @ApiOperation(value = "xoá một sản phẩm khuyến mãi", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.PROMOTION_PRODUCT_NOT_FOUND)
    })
    @AuthorizationRequired
    @DeleteMapping("/promotion-products/{id}")
    public BaseResponse deletePromotionProduct(@PathVariable("id") Integer id) {
        return saleProductService.deleteSaleProduct(id);
    }

    @ApiOperation(value = "Xóa một danh sách sản phẩm khuyến mãi", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @AuthorizationRequired
    @DeleteMapping("/promotion-products")
    public BaseResponse deleteListProduct(@RequestBody Set<Integer> ids) {
        return saleProductService.deleteListSaleProduct(ids);
    }
}
