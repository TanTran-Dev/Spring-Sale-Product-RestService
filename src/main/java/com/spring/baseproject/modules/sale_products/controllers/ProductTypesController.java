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
import com.spring.baseproject.modules.sale_products.models.dtos.product_type.NewProductTypeDto;
import com.spring.baseproject.modules.sale_products.services.ProductTypesService;
import com.spring.baseproject.swagger.sale_products.product_type.ListProductTypeDtoSwagger;
import com.spring.baseproject.swagger.sale_products.product_type.ProductTypeDtoSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/product-type")
@Api(description = "Loại sản phẩm")
public class ProductTypesController extends BaseRESTController {
    @Autowired
    private ProductTypesService productTypesService;

    @ApiOperation(value = "Tạo mới một loại sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @AuthorizationRequired
    @PostMapping("/newProductType")
    public BaseResponse addProductType(@RequestBody @Valid NewProductTypeDto newProductTypeDto) {
        return productTypesService.createNewProductType(newProductTypeDto);
    }

    @ApiOperation(value = "Lấy danh sách các loại sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = ListProductTypeDtoSwagger.class)
    })
    @GetMapping("/productTypes")
    public BaseResponse getProductTypes(@RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
                                        @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType,
                                        @RequestParam(value = StringConstants.PAGE_INDEX, defaultValue = "0") int pageIndex,
                                        @RequestParam(value = StringConstants.PAGE_SIZE, defaultValue = NumberConstants.MAX_PAGE_SIZE + "") int pageSize) {
        return productTypesService.getListProductTypeDtos(sortBy, sortType, pageIndex, pageSize);
    }

    @ApiOperation(value = "Xem thông tin loại sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = ProductTypeDtoSwagger.class),
            @Response(responseValue = ResponseValue.PRODUCT_TYPE_NOT_FOUND)
    })
    @GetMapping("/productTypes/{productTypeId}")
    public BaseResponse getProductType(@PathVariable("productTypeId") Integer productTypeId) {
        return productTypesService.getProductTypeDto(productTypeId);
    }

    @ApiOperation(value = "Xoá danh sách một loại sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @DeleteMapping("/productTypes")
    public BaseResponse deleteListProduct(@RequestBody Set<Integer> productTypeIds) {
        return productTypesService.deleteListProductTypes(productTypeIds);
    }
}
