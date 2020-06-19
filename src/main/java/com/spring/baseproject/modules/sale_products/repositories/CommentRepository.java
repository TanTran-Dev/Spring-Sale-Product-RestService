package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.dtos.comment.CommentDto;
import com.spring.baseproject.modules.sale_products.models.entities.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, String> {
    Comment findFirstById(String commentId);

    @Query("select c " +
            "from Comment c " +
            "left join c.customer " +
            "left join c.product p " +
            "where p.id = ?1")
    Page<Comment> getPageComment(Integer productId, Pageable pageable);

    @Query("select c " +
            "from Comment c " +
            "left join c.customer " +
            "left join c.product " +
            "where c.id = ?1")
    CommentDto getCommentDto(String commentId);
}
