package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.sale_products.models.dtos.product_type.NewProductTypeDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product_type.ProductTypeDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product_type.ProductTypeImageUrlDto;
import com.spring.baseproject.modules.sale_products.models.entities.ProductType;
import com.spring.baseproject.modules.sale_products.repositories.ProductTypesRepository;
import com.spring.baseproject.modules.sale_products.services.file.FirebaseImageService;
import com.spring.baseproject.utils.jpa.SortAndPageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ProductTypesService {
    @Autowired
    ProductTypesRepository productTypesRepository;

    @Autowired
    FirebaseImageService firebaseImageService;

    public BaseResponse createNewProductType(NewProductTypeDto newProductTypeDto){
        ProductType productType = new ProductType(newProductTypeDto);
        productTypesRepository.save(productType);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse getListProductTypeDtos(List<String> sortBy, List<String> sortType, int pageIndex, int pageSize){
        Pageable pageable = SortAndPageFactory.createPageable(sortBy, sortType, pageIndex, pageSize, NumberConstants.MAX_PAGE_SIZE);
        Page<ProductTypeDto> productTypeDtos = productTypesRepository.getPageProductTypeDtos(pageable);
        return new BaseResponse(ResponseValue.SUCCESS, productTypeDtos);
    }

    public BaseResponse getProductTypeDto(Integer productTypeId){
        ProductTypeDto productTypeDto = productTypesRepository.getProductTypeDto(productTypeId);
        if (productTypeDto == null){
            return new BaseResponse(ResponseValue.PRODUCT_TYPE_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, productTypeDto);
    }

    public ProductTypeImageUrlDto updateProductTypeImageUrl(Integer productTypeID, MultipartFile imageFile) throws IOException {
        checkProductTypeExists(productTypeID);
        String oldImageUrl = productTypesRepository.getProductTypeImageUrl(productTypeID);
        String newImageUrl = firebaseImageService.save(imageFile);
        firebaseImageService.delete(oldImageUrl);

        productTypesRepository.updateProductTypeImage(productTypeID, newImageUrl);
    }


    public BaseResponse checkProductTypeExists(Integer productTypeID){
        if (!productTypesRepository.existsById(productTypeID)){
            return new BaseResponse(ResponseValue.PRODUCT_TYPE_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse updateProductType(Integer productTypeId, NewProductTypeDto newProductTypeDto){
        ProductType productType = productTypesRepository.findFirstById(productTypeId);
        if (productType == null){
            return new BaseResponse(ResponseValue.PRODUCT_TYPE_NOT_FOUND);
        }
        productType.update(newProductTypeDto);
        productTypesRepository.save(productType);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse deleteProductType(Integer productTypeID) {
        try {
            productTypesRepository.deleteById(productTypeID);
            return new BaseResponse(ResponseValue.SUCCESS);
        } catch (EmptyResultDataAccessException e) {
            return new BaseResponse(ResponseValue.PRODUCT_TYPE_NOT_FOUND);
        }
    }

    public BaseResponse deleteListProductTypes(Set<Integer> productTypeIDs) {
        productTypesRepository.deleteAllByIdIn(productTypeIDs);
        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
