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
import com.spring.baseproject.modules.sale_products.models.dtos.order_product.NewOrderProductDto;
import com.spring.baseproject.modules.sale_products.services.OrderProductService;
import com.spring.baseproject.swagger.sale_products.order_product.OrderProductDto;
import com.spring.baseproject.swagger.sale_products.order_product.ResponseOrderProduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/order-product")
@Api(description = "Đơn hàng")
public class OrderProductController extends BaseRESTController {
    @Autowired
    private OrderProductService orderProductService;

    @ApiOperation(value = "Tạo mới một đơn hàng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @PostMapping("/new-order")
    public BaseResponse addOrderProduct(@RequestBody @Valid NewOrderProductDto newOrderProductDto) {
        return orderProductService.createNewOrder(newOrderProductDto);
    }

    @ApiOperation(value = "Lấy danh sách các đơn hàng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = ResponseOrderProduct.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @GetMapping("/order-products")
    public BaseResponse getPageProducts(
            @RequestParam(value = "customerId") String customerId,
            @RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
            @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType,
            @RequestParam(value = StringConstants.PAGE_INDEX, defaultValue = "0") int pageIndex,
            @RequestParam(value = StringConstants.PAGE_SIZE, defaultValue = NumberConstants.MAX_PAGE_SIZE + "") int pageSize) {
        return orderProductService.getPageOrderProductPreviewDtos(customerId, sortBy, sortType, pageIndex, pageSize);
    }

    @ApiOperation(value = "Xem thông tin chi tiết đơn hàng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = OrderProductDto.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @GetMapping("/order-product")
    public BaseResponse getPageProducts(@RequestParam("orderId") String orderProductID) {
        return orderProductService.getOrderProductPreviewDto(orderProductID);
    }

    @ApiOperation(value = "Xóa một danh sách đơn hàng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @DeleteMapping("/order-products")
    public BaseResponse deleteProduct(@RequestBody Set<String> orderProductIDs) {
        return orderProductService.deleteListOrderProducts(orderProductIDs);
    }
}
