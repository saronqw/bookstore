package com.biblio.alpha.entity.basket;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.entity.CustomerEntity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BasketId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasketId)) return false;
        BasketId basketId = (BasketId) o;
        return bookEntity.equals(basketId.bookEntity) &&
                customerEntity.equals(basketId.customerEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookEntity, customerEntity);
    }
}
