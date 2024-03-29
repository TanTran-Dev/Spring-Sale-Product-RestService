package com.spring.baseproject.modules.sale_products.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.salesman.repositories.SalesmanRepository;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.customer.repositories.CustomerRepository;
import com.spring.baseproject.modules.sale_products.models.dtos.comment.CommentDto;
import com.spring.baseproject.modules.sale_products.models.dtos.comment.NewCommentDto;
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
    private SalesmanRepository salesmanRepository;

    public BaseResponse createNewComment(NewCommentDto newCommentDto) {
        Customer customer = customerRepository.findFirstById(newCommentDto.getCustomerId());
        if (customer == null) {
            return new BaseResponse(ResponseValue.CUSTOMER_NOT_FOUND);
        }

        Product product = productRepository.findFirstById(newCommentDto.getProductId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }

        Comment comment = new Comment(customer, product, newCommentDto);

        commentRepository.save(comment);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public BaseResponse getPageCommentDto(Integer productId,
                                          List<String> sortBy, List<String> sortType, int pageIndex, int pageSize) {
        Pageable pageable = SortAndPageFactory.createPageable(sortBy, sortType, pageIndex, pageSize, NumberConstants.MAX_PAGE_SIZE);
        Page<CommentDto> commentPage = commentRepository.getPageComment(productId, pageable);

        return new BaseResponse(ResponseValue.SUCCESS, commentPage);
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

        Product product = productRepository.findFirstById(comment.getProduct().getId());
        if (product == null) {
            return new BaseResponse(ResponseValue.PRODUCT_NOT_FOUND);
        }

        commentRepository.save(comment);

        return new BaseResponse(ResponseValue.SUCCESS);
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
