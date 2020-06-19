package com.spring.baseproject.modules.sale_products.controllers;

import com.spring.baseproject.annotations.auth.AuthorizationRequired;
import com.spring.baseproject.annotations.swagger.Response;
import com.spring.baseproject.annotations.swagger.Responses;
import com.spring.baseproject.base.controllers.BaseRESTController;
import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.base.models.BaseResponseBody;
import com.spring.baseproject.constants.NumberConstants;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.constants.StringConstants;
import com.spring.baseproject.modules.sale_products.models.dtos.comment.NewCommentDto;
import com.spring.baseproject.modules.sale_products.services.CommentService;
import com.spring.baseproject.swagger.sale_products.comment.PageCommentsSwagger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
@Api(description = "Bình luận về sản phẩm")
public class CommentController extends BaseRESTController {
    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "Tạo mới một bình luận", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class)
    })
    @AuthorizationRequired
    @PostMapping("/new-comment")
    public BaseResponse addOrderProduct(@RequestBody @Valid NewCommentDto newCommentDto) {
        return commentService.createNewComment(newCommentDto);
    }

    @ApiOperation(value = "Lấy danh sách các bình luận", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = PageCommentsSwagger.class),
            @Response(responseValue = ResponseValue.COMMENT_NOT_FOUND)
    })
    @GetMapping("/comments{productId}")
    public BaseResponse getPageProducts(
            @RequestParam(value = "productId", defaultValue = "0") Integer productId,
            @RequestParam(value = StringConstants.SORT_BY, defaultValue = "", required = false) List<String> sortBy,
            @RequestParam(value = StringConstants.SORT_TYPE, defaultValue = "", required = false) List<String> sortType,
            @RequestParam(value = StringConstants.PAGE_INDEX, defaultValue = "0") int pageIndex,
            @RequestParam(value = StringConstants.PAGE_SIZE, defaultValue = NumberConstants.MAX_PAGE_SIZE + "") int pageSize) {
        return commentService.getPageCommentDto(productId, sortBy, sortType, pageIndex, pageSize);
    }

    @ApiOperation(value = "Chỉnh sửa bình luận", response = Iterable.class)
    @Responses(value = {
            @Response(responseValue = ResponseValue.SUCCESS, responseBody = BaseResponseBody.class),
            @Response(responseValue = ResponseValue.COMMENT_NOT_FOUND)
    })
    @AuthorizationRequired
    @PutMapping("/comments/{id}")
    public BaseResponse updateProduct(@PathVariable("id") String commentId,
                                      @RequestParam("content") String content) {
        return commentService.updateComment(commentId, content);
    }
}
