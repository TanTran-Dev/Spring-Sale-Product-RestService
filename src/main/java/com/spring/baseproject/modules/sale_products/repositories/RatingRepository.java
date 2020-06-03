package com.spring.baseproject.modules.sale_products.repositories;

import com.spring.baseproject.modules.sale_products.models.entities.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingRepository extends JpaRepository<Rating, String> {
    Rating findFirstById(String ratingID);

    @Query("select r " +
            "from Rating r " +
            "left join r.customer " +
            "left join r.product")
    Page<Rating> getPageRating(Pageable pageable);

    @Query("select r " +
            "from Rating r " +
            "left join r.customer " +
            "left join r.product " +
            "where r.id = ?1")
    Rating getRating(String ratingId);
}
