package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.PageDto;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.admin.models.dtos.AdminDto;
import com.spring.baseproject.modules.admin.repositories.AdminRepository;
import com.spring.baseproject.modules.customer.models.dtos.CustomerDto;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.customer.repositories.CustomerRepository;
import com.spring.baseproject.modules.sale_products.models.dtos.comment.CommentDto;
import com.spring.baseproject.modules.sale_products.models.dtos.comment.NewCommentDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product.ProductDto;
import com.spring.baseproject.modules.sale_products.models.dtos.product_type.ProductTypeDto;
import com.spring.baseproject.modules.sale_products.models.dtos.trademark.TrademarkDto;
import com.spring.baseproject.modules.sale_products.models.entities.Comment;
import com.spring.baseproject.modules.sale_products.models.entities.Product;
import com.spring.baseproject.modules.sale_products.repositories.CommentRepository;
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

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypesRepository productTypesRepository;

    @Autowired
    private TrademarkRepository trademarkRepository;

    @Autowired
    private AdminRepository adminRepository;

    public BaseResponse createNewComment(NewCommentDto newCommentDto) {
        Customer customer = customerRepository.findFirstById(newCommentDto.getCustomerId());
        if (customer == null) {
            return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
        }
        CustomerDto customerDto = new CustomerDto(customer);

        Product product = productRepository.findFirstById(newCommentDto.getProductId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
        ProductDto productDto = new ProductDto(product);

        Comment comment = new Comment(customer, product, newCommentDto);

        commentRepository.save(comment);

        CommentDto commentDto = new CommentDto(customerDto, productDto, comment);

        return new BaseResponse(ResponseValue.SUCCESS, commentDto);
    }

    public BaseResponse getPageCommentDto(
            Integer productId,
            List<String> sortBy, List<String> sortType, int pageIndex, int pageSize) {
        Pageable pageable = SortAndPageFactory.createPageable(sortBy, sortType, pageIndex, pageSize, NumberConstants.MAX_PAGE_SIZE);
        Page<Comment> commentPage = commentRepository.getPageComment(productId, pageable);

        List<CommentDto> listResult = new ArrayList<>();

        for (Comment comment : commentPage.getContent()) {
            Customer customer = customerRepository.findFirstById(comment.getCustomer().getId());
            if (customer == null) {
                return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
            }
            CustomerDto customerDto = new CustomerDto(customer);

            Product product = productRepository.findFirstById(productId);
            if (product == null) {
                return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
            }
            ProductDto productDto = new ProductDto(product);

            ProductTypeDto productTypeDto = productTypesRepository.getProductTypeDto(product.getProductType().getId());
            TrademarkDto trademarkDto = trademarkRepository.getTrademarkDto(product.getTrademark().getId());
            AdminDto adminDto = adminRepository.getAdminDto(product.getAdmin().getId());

            CommentDto commentDto = new CommentDto(customerDto, productDto, comment);
            commentDto.getProductDto().setProductTypeDto(productTypeDto);
            commentDto.getProductDto().setTrademarkDto(trademarkDto);
            commentDto.getProductDto().setAdminDto(adminDto);

            listResult.add(commentDto);
        }
        PageDto<CommentDto> commentDtoPageDto = new PageDto<>(
                listResult, commentPage.getNumber(), commentPage.getSize(), commentPage.getTotalElements());
        return new BaseResponse(ResponseValue.SUCCESS, commentDtoPageDto);
    }

    public BaseResponse updateComment(String commentId, String content) {
        Comment comment = commentRepository.findFirstById(commentId);
        if (comment == null) {
            return new BaseResponse(ResponseValue.COMMENT_NOT_FOUND);
        }
        comment.setContent(content);

        Customer customer = customerRepository.findFirstById(comment.getCustomer().getId());
        if (customer == null) {
            return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
        }
        CustomerDto customerDto = new CustomerDto(customer);

        Product product = productRepository.findFirstById(comment.getProduct().getId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }
        ProductDto productDto = new ProductDto(product);

        commentRepository.save(comment);

        CommentDto commentDto = new CommentDto(customerDto, productDto, comment);

        return new BaseResponse(ResponseValue.SUCCESS, commentDto);
    }

    public BaseResponse deleteComment(String commentId){
        try {
            commentRepository.deleteById(commentId);
            return new BaseResponse(ResponseValue.SUCCESS);
        } catch (EmptyResultDataAccessException e) {
            return new BaseResponse(ResponseValue.COMMENT_NOT_FOUND);
        }
    }
}
