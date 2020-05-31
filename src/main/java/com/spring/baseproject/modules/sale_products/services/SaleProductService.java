package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.sale_products.models.dtos.sale_product.NewSaleProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.sale_product.SaleProductDto;
import com.spring.baseproject.modules.sale_products.models.entities.Product;
import com.spring.baseproject.modules.sale_products.models.entities.SaleProduct;
import com.spring.baseproject.modules.sale_products.repositories.ProductRepository;
import com.spring.baseproject.modules.sale_products.repositories.SaleProductRepository;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SaleProductService {
    @Autowired
    private SaleProductRepository saleProductRepository;

    @Autowired
    private ProductRepository productRepository;

    public BaseResponse createNewSaleProduct(NewSaleProductDto newSaleProductDto) {
        Product product = productRepository.findFirstById(newSaleProductDto.getProductId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
        product.setSale(true);

        int priceProduct = product.getPrice();

        SaleProduct saleProduct = new SaleProduct(product, newSaleProductDto);

        int pricePromotion = calPriceProductAfterPromotion(priceProduct, saleProduct.getPercent());

        saleProduct.setPricePromotion(pricePromotion);
        saleProductRepository.save(saleProduct);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse getPageSaleProductDtos(List<String> sortBy, List<String> sortType, int pageIndex, int pageSize) {
        Pageable pageable = SortAndPageFactory.createPageable(sortBy, sortType, pageIndex, pageSize, NumberConstants.MAX_PAGE_SIZE);
        Page<SaleProductDto> promotionProductDtos = saleProductRepository.getPagePromotionProductDto(pageable);
        return new BaseResponse(ResponseValue.SUCCESS, promotionProductDtos);
    }

    public BaseResponse getSaleProductDto(Integer id) {
        SaleProductDto saleProductDto = saleProductRepository.getPromotionProductDto(id);
        if (saleProductDto == null) {
            return new BaseResponse(ResponseValue.PROMOTION_PRODUCT_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, saleProductDto);
    }

    public BaseResponse updateSaleProduct(Integer id, NewSaleProductDto newSaleProductDto) {
        Product product = productRepository.findFirstById(newSaleProductDto.getProductId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
        product.setSale(true);
        int priceProduct = product.getPrice();

        SaleProduct saleProduct = saleProductRepository.findFirstById(id);
        if (saleProduct == null) {
            return new BaseResponse(ResponseValue.PROMOTION_PRODUCT_NOT_FOUND);
        }
        saleProduct.update(product, newSaleProductDto);
        int pricePromotion = calPriceProductAfterPromotion(priceProduct, saleProduct.getPercent());
        saleProduct.setPricePromotion(pricePromotion);

        saleProductRepository.save(saleProduct);
        return new BaseResponse(ResponseValue.SUCCESS, saleProduct);
    }

    public BaseResponse deleteSaleProduct(Integer id) {
        SaleProduct saleProduct = saleProductRepository.findFirstById(id);
        Product product = productRepository.findFirstById(saleProduct.getProduct().getId());
        try {
            product.setSale(false);
            saleProductRepository.deleteById(id);
            return new BaseResponse(ResponseValue.SUCCESS);
        } catch (EmptyResultDataAccessException e) {
            return new BaseResponse(ResponseValue.PROMOTION_PRODUCT_NOT_FOUND);
        }
    }

    public BaseResponse deleteListSaleProduct(Set<Integer> ids) {
        saleProductRepository.deleteAllByIdIn(ids);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public int calPriceProductAfterPromotion(int priceProduct, float percent) {
        float percentPromotion = percent / 100;
        int pricePromotion = (int) (priceProduct * percentPromotion);
        int result = priceProduct - pricePromotion;

        return result;
    }
}
