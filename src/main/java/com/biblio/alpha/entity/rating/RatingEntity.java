package com.biblio.alpha.entity.rating;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.entity.CustomerEntity;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

@Validated
@Entity
@Table(name = "ratings")
public class RatingEntity {

    public RatingEntity() {
    }

    @EmbeddedId
    private RatingId id;

    @Size(max = 10, message = "The value must be range of 1 to 10")
    @Column(name = "rating")
    private Long rating;

    @Column(name = "review")
    private String review;


    public RatingId getId() {
        return id;
    }

    public void setId(RatingId id) {
        this.id = id;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "RatingEntity{" +
                "customer_id=" + id.customerEntity.getCustomerId() +
                ", book_id=" + id.bookEntity.getBookId() +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}

