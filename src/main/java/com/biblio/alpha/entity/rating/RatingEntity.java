package com.biblio.alpha.entity.rating;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;

@Validated
@Entity
@Table(name = "ratings")
public class RatingEntity {

    public RatingEntity() {
    }

    @EmbeddedId
    private RatingId id;

    @Column(name = "rating")
    @Min(value = 1, message = "The value must be range of 1 to 10")
    @Max(value = 10, message = "The value must be range of 1 to 10")
    private Byte rating;

    @NotEmpty
    @Size(min = 32, max = 512)
    @Column(name = "review")
    private String review;


    public RatingId getId() {
        return id;
    }

    public void setId(RatingId id) {
        this.id = id;
    }

    public Byte getRating() {
        return rating;
    }

    public void setRating(Byte rating) {
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

