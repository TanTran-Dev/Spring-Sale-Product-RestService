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
import com.spring.baseproject.modules.sale_products.models.dtos.product.NewProductDto;
import com.spring.baseproject.modules.sale_products.services.ProductService;
import com.spring.baseproject.swagger.sale_products.product.PageProductDtoSwagger;
import com.spring.baseproject.swagger.sale_products.product.ProductDtoSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/product")
@Api(description = "Sản phẩm")
public class ProductController extends BaseRESTController {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Tạo mới một sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @AuthorizationRequired
    @PostMapping("/newProduct")
    public BaseResponse addProduct(@RequestBody @Valid NewProductDto newProductDto) {
        return productService.createNewProductDto(newProductDto);
    }


    @ApiOperation(value = "Lấy danh sách các sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = PageProductDtoSwagger.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @GetMapping("/products")
    public BaseResponse getPageProducts(
            @RequestParam(value = "productTypeID", defaultValue = "0") Integer productTypeId,
            @RequestParam(value = "trademarkID", defaultValue = "0") Integer trademarkId,
            @RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
            @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType,
            @RequestParam(value = StringConstants.PAGE_INDEX, defaultValue = "0") int pageIndex,
            @RequestParam(value = StringConstants.PAGE_SIZE, defaultValue = NumberConstants.MAX_PAGE_SIZE + "") int pageSize) {
        return productService.getPageProductDto(productTypeId, trademarkId, sortBy, sortType, pageIndex, pageSize);
    }


    @ApiOperation(value = "Lấy danh sách các sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = PageProductDtoSwagger.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @GetMapping("/products/all")
    public BaseResponse getAllProducts(
            @RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
            @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType,
            @RequestParam(value = StringConstants.PAGE_INDEX, defaultValue = "0") int pageIndex,
            @RequestParam(value = StringConstants.PAGE_SIZE, defaultValue = NumberConstants.MAX_PAGE_SIZE + "") int pageSize) {
        return productService.getAllProductDto();
    }

    @ApiOperation(value = "Lấy ra thông tin chi tiết sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = ProductDtoSwagger.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @GetMapping("/products/{id}")
    public BaseResponse getPageProducts(@PathVariable("id") Integer productId) {
        return productService.getProductDto(productId);
    }

    @ApiOperation(value = "Cập nhật thông tin chi tiết sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @AuthorizationRequired
    @PutMapping("/products/{id}")
    public BaseResponse updateProduct(@PathVariable("id") Integer productId,
                                      @RequestBody @Valid NewProductDto newProductDto) {
        return productService.updateProduct(productId, newProductDto);
    }

    @ApiOperation(value = "Xóa một sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @AuthorizationRequired
    @DeleteMapping("/products/{id}")
    public BaseResponse deleteProduct(@PathVariable("id") Integer productId) {
        return productService.deleteProduct(productId);
    }

    @ApiOperation(value = "Xóa một danh sách sản phẩm", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @AuthorizationRequired
    @DeleteMapping("/products")
    public BaseResponse deleteListProduct(@RequestBody Set<Integer> productIds) {
        return productService.deleteListProduct(productIds);
    }
}
