package com.spring.baseproject.modules.sale_products.controllers;

import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.sale_products.services.ShoppingCartService;
import com.spring.baseproject.swagger.sale_products.shopping_cart.ShoppingCartSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/shopping-cart")
@Api(description = "Giỏ hàng")
public class ShoppingCartController extends BaseRESTController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @ApiOperation(value = "Lấy ra thông tin các sản phẩm trong giỏ hàng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = ShoppingCartSwagger.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @GetMapping("/shopping-cart")
    public BaseResponse getShoppingCart(@RequestParam("customerId") String customerId){
        return shoppingCartService.getShoppingCart(customerId);
    }
}
