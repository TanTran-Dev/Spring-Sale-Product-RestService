package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product.NewShoppingCartProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.shopping_cart_product.ShoppingCartProductDto;
import com.spring.baseproject.modules.sale_products.models.entities.Product;
import com.spring.baseproject.modules.sale_products.models.entities.ShoppingCart;
import com.spring.baseproject.modules.sale_products.models.entities.ShoppingCartProduct;
import com.spring.baseproject.modules.sale_products.repositories.ProductRepository;
import com.spring.baseproject.modules.sale_products.repositories.ShoppingCartProductRepository;
import com.spring.baseproject.modules.sale_products.repositories.ShoppingCartRepository;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartProductService {
    @Autowired
    private ShoppingCartProductRepository shoppingCartProductRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    public BaseResponse createShoppingCartProduct(NewShoppingCartProductDto newShoppingCartProductDto) {
        Product product = productRepository.findFirstById(newShoppingCartProductDto.getProductId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }

        ShoppingCart shoppingCart = shoppingCartRepository.findFirstById(newShoppingCartProductDto.getShoppingCartId());
        if (shoppingCart == null) {
            return new BaseResponse(ResponseValue.SHOPPING_CART_NOT_FOUND);
        }
        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(newShoppingCartProductDto);
        if (shoppingCartProduct == null) {
            return new BaseResponse(ResponseValue.SHOPPING_CART_NOT_FOUND);
        }
        shoppingCartProduct.setProduct(product);
        shoppingCartProduct.setShoppingCart(shoppingCart);

        shoppingCartProductRepository.save(shoppingCartProduct);
        return new BaseResponse(ResponseValue.SUCCESS, shoppingCartProduct);
    }

    public BaseResponse getPageShoppingCartProduct(List<String> sortBy, List<String> sortType,
                                                   int pageIndex, int pageSize) {
        Pageable pageable = SortAndPageFactory.createPageable(sortBy, sortType, pageIndex, pageSize, NumberConstants.MAX_PAGE_SIZE);
        Page<ShoppingCartProduct> shoppingCartProducts = shoppingCartProductRepository.getPageShoppingCartProductDto(pageable);
        return new BaseResponse(ResponseValue.SUCCESS, shoppingCartProducts);
    }

    public BaseResponse getShoppingCartProduct(Integer productId){
        ShoppingCartProductDto shoppingCartProductDto = shoppingCartProductRepository.getShoppingCartProductDto(productId);
        if (shoppingCartProductDto == null){
            Product product = productRepository.findFirstById(productId);
            if (product == null){
                return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
            }
        }

        return new BaseResponse(ResponseValue.SUCCESS, shoppingCartProductDto);
    }
}
