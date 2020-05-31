package com.spring.baseproject.modules.sale_products.controllers;

import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.StringConstants;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product.NewShoppingCartProductDto;
import com.spring.baseproject.modules.sale_products.services.ShoppingCartProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/shopping-cart-product")
@Api(description = "")
public class ShoppingCartProductController extends BaseRESTController {
    @Autowired
    private ShoppingCartProductService shoppingCartProductService;

    @PostMapping("/new-shopping-cart-product")
    public BaseResponse createShoppingCartProduct(@RequestBody @Valid NewShoppingCartProductDto newShoppingCartProductDto) {
        return shoppingCartProductService.createShoppingCartProduct(newShoppingCartProductDto);
    }

    @GetMapping("/shopping-cart-products")
    public BaseResponse getPageShoppingCartProducts(@RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
                                                    @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType,
                                                    @RequestParam(value = StringConstants.PAGE_INDEX, defaultValue = "0") int pageIndex,
                                                    @RequestParam(value = StringConstants.PAGE_SIZE, defaultValue = NumberConstants.MAX_PAGE_SIZE + "") int pageSize) {
        return shoppingCartProductService.getPageShoppingCartProduct(sortBy, sortType, pageIndex, pageSize);
    }

    @GetMapping("/shopping-cart-products/{pId}")
    public BaseResponse getShoppingCartProduct(@PathVariable("pId") Integer productId) {
        return shoppingCartProductService.getShoppingCartProduct(productId);
    }
}
