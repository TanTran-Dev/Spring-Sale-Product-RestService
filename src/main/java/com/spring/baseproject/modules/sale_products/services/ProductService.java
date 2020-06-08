package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.PageDto;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.admin.repositories.AdminRepository;
import com.spring.baseproject.modules.sale_products.models.dtos.product.NewProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductPreviewDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product_type.ProductTypeDto;
import com.spring.baseproject.modules.sale_products.models.entities.Product;
import com.spring.baseproject.modules.sale_products.models.entities.ProductType;
import com.spring.baseproject.modules.sale_products.models.entities.Trademark;
import com.spring.baseproject.modules.sale_products.repositories.ProductRepository;
import com.spring.baseproject.modules.sale_products.repositories.ProductTypesRepository;
import com.spring.baseproject.modules.sale_products.repositories.TrademarkRepository;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypesRepository productTypesRepository;

    @Autowired
    private TrademarkRepository trademarkRepository;

    @Autowired
    private AdminRepository adminRepository;

    public BaseResponse createNewProductDto(NewProductDto newProductDto) {
        ProductType productType = productTypesRepository.findFirstById(newProductDto.getProductTypeId());
        if (productType == null) {
            return new BaseResponse(ResponseValue.PRODUCT_TYPE_NOT_FOUND);
        }

        Trademark trademark = trademarkRepository.findFirstById(newProductDto.getTrademarkId());
        if (trademark == null) {
            return new BaseResponse(ResponseValue.TRADEMARK_NOT_FOUND);
        }
        Admin admin = adminRepository.findFirstById(newProductDto.getAdminId());
        if (admin == null) {
            return new BaseResponse(ResponseValue.ADMIN_NOT_FOUND);
        }
        Product product = new Product(admin, productType, trademark, newProductDto);

        productRepository.save(product);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse getPageProductDto(Integer productTypeId,
                                          List<String> sortBy, List<String> sortType,
                                          int pageIndex, int pageSize) {
        ProductType productType = productTypesRepository.findFirstById(productTypeId);
        if (productType == null){
            return new BaseResponse(ResponseValue.PRODUCT_TYPE_NOT_FOUND);
        }
        ProductTypeDto productTypeDto = new ProductTypeDto(productType);

        Pageable pageable = SortAndPageFactory.createPageable(sortBy, sortType, pageIndex, pageSize, NumberConstants.MAX_PAGE_SIZE);
        Page<Product> products = productRepository.getPageProduct(pageable);
        List<ProductPreviewDto> previewDtoList = new ArrayList<>();

        for (Product product : products){
            if (productTypeDto.getId() == product.getProductType().getId()){
                product.setProductType(productType);
                
                ProductPreviewDto productPreviewDto = new ProductPreviewDto(product);
                productPreviewDto.setProductTypeDto(productTypeDto);
                previewDtoList.add(productPreviewDto);
            }
        }
        return new BaseResponse(ResponseValue.SUCCESS, new PageDto<>(previewDtoList, products.getNumber(), products.getSize(), products.getTotalElements()));
    }

    public BaseResponse getProductDto(Integer id) {
        ProductDto productDto = productRepository.getProductDto(id);
        if (productDto == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, productDto);
    }

    public BaseResponse updateProduct(Integer productId, NewProductDto newProductDto) {
        ProductType productType = productTypesRepository.findFirstById(newProductDto.getProductTypeId());
        if (productType == null) {
            return new BaseResponse(ResponseValue.PRODUCT_TYPE_NOT_FOUND);
        }
        Trademark trademark = trademarkRepository.findFirstById(newProductDto.getTrademarkId());
        if (trademark == null) {
            return new BaseResponse(ResponseValue.TRADEMARK_NOT_FOUND);
        }
        Admin admin = adminRepository.findFirstById(newProductDto.getAdminId());
        if (admin == null) {
            return new BaseResponse(ResponseValue.ADMIN_NOT_FOUND);
        }

        Product product = productRepository.findFirstById(productId);
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
        product.update(admin, productType, trademark, newProductDto);
        productRepository.save(product);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse deleteProduct(Integer productId) {
        try {
            productRepository.deleteById(productId);
            return new BaseResponse(ResponseValue.SUCCESS);
        } catch (EmptyResultDataAccessException e) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
    }

    public BaseResponse deleteListProduct(Set<Integer> productIds) {
        productRepository.deleteAllByIdIn(productIds);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse getAllProductDto() {
        return new BaseResponse(ResponseValue.SUCCESS, productRepository.findAll());
    }
}
