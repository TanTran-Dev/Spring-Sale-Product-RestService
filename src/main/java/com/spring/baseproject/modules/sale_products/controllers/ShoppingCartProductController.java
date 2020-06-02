package com.spring.baseproject.modules.sale_products.controllers;

import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.constants.StringConstants;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product.NewShoppingCartProductDto;
import com.spring.baseproject.modules.sale_products.services.ShoppingCartProductService;
import com.spring.baseproject.swagger.sale_products.shopping_cart_product.PageShoppingCartProductSwagger;
import com.spring.baseproject.swagger.sale_products.shopping_cart_product.ShoppingCartProductSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/shopping-cart-product")
@Api(description = "Sản phẩm trong giỏ hàng")
public class ShoppingCartProductController extends BaseRESTController {
    @Autowired
    private ShoppingCartProductService shoppingCartProductService;

    @ApiOperation(value = "Thêm một sản phẩm vào giỏ hàng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @PostMapping("/new-shopping-cart-product")
    public BaseResponse createShoppingCartProduct(@RequestBody @Valid NewShoppingCartProductDto newShoppingCartProductDto) {
        return shoppingCartProductService.createShoppingCartProductDto(newShoppingCartProductDto);
    }


    @ApiOperation(value = "Lấy ra danh sách các sản phẩm trong giỏ hàng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = PageShoppingCartProductSwagger.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @GetMapping("/shopping-cart-products")
    public BaseResponse getPageShoppingCartProducts(@RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
                                                    @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType,
                                                    @RequestParam(value = StringConstants.PAGE_INDEX, defaultValue = "0") int pageIndex,
                                                    @RequestParam(value = StringConstants.PAGE_SIZE, defaultValue = NumberConstants.MAX_PAGE_SIZE + "") int pageSize) {
        return shoppingCartProductService.getPageShoppingCartProduct(sortBy, sortType, pageIndex, pageSize);
    }

    @ApiOperation(value = "Lấy ra thông tin sản phẩm trong giỏ hàng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = ShoppingCartProductSwagger.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @GetMapping("/shopping-cart-products/{pId}")
    public BaseResponse getShoppingCartProduct(@PathVariable("pId") Integer productId) {
        return shoppingCartProductService.getShoppingCartProduct(productId);
    }

    @ApiOperation(value = "Cập nhật sản phẩm trong giỏ hàng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.PRODUCT_NOT_FOUND)
    })
    @PutMapping("/shopping-cart-product")
    public BaseResponse updateShoppingCartProduct(@RequestParam("scpID") String shoppingCartProductID,
                                                  @RequestBody @Valid NewShoppingCartProductDto newShoppingCartProductDto){
        return shoppingCartProductService.updateShoppingCartProduct(shoppingCartProductID, newShoppingCartProductDto);
    }

    @ApiOperation(value = "Xóa một danh sách sản phẩm trong giỏ hàng", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @DeleteMapping("/shopping-cart-products")
    public BaseResponse deleteListShoppingCartProduct(@RequestBody Set<String> shoppingCartProductIDs){
        return shoppingCartProductService.deleteListShoppingCart(shoppingCartProductIDs);
    }
}
