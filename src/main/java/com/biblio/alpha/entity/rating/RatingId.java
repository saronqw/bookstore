package com.biblio.alpha.entity.rating;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.entity.CustomerEntity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RatingId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    protected CustomerEntity customerEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    protected BookEntity bookEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatingId)) return false;
        RatingId ratingId = (RatingId) o;
        return customerEntity.equals(ratingId.customerEntity) &&
                bookEntity.equals(ratingId.bookEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerEntity, bookEntity);
    }
}
