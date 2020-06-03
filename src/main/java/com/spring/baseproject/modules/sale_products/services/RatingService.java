package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.customer.repositories.CustomerRepository;
import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.rating.NewRatingDto;
import com.spring.baseproject.modules.sale_products.models.dtos.rating.RatingDto;
import com.spring.baseproject.modules.sale_products.models.entities.Product;
import com.spring.baseproject.modules.sale_products.models.entities.Rating;
import com.spring.baseproject.modules.sale_products.repositories.ProductRepository;
import com.spring.baseproject.modules.sale_products.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public BaseResponse createNewRating(NewRatingDto newRatingDto) {

        Customer customer = customerRepository.findFirstById(newRatingDto.getCustomerId());
        if (customer == null) {
            return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
        }
        CustomerDto customerDto = new CustomerDto(customer);

        Product product = productRepository.findFirstById(newRatingDto.getProductId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
        ProductDto productDto = new ProductDto(product);
        Rating rating = new Rating(customer, product, newRatingDto);

        ratingRepository.save(rating);

        RatingDto ratingDto = new RatingDto(customerDto, productDto, rating);

        return new BaseResponse(ResponseValue.SUCCESS, ratingDto);
    }

    public BaseResponse updateRating(String ratingId, String content, Float ratingStar) {
        Rating rating = ratingRepository.getRating(ratingId);
        if (rating == null) {
            return new BaseResponse(ResponseValue.RATING_NOT_FOUND);
        }

        Customer customer = customerRepository.findFirstById(rating.getCustomer().getId());
        if (customer == null) {
            return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
        }
        CustomerDto customerDto = new CustomerDto(customer);

        Product product = productRepository.findFirstById(rating.getProduct().getId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
        ProductDto productDto = new ProductDto(product);


        rating.setContent(content);
        rating.setRatingStar(ratingStar);

        ratingRepository.save(rating);

        RatingDto ratingDto = new RatingDto(customerDto, productDto, rating);

        return new BaseResponse(ResponseValue.SUCCESS, ratingDto);
    }
}
