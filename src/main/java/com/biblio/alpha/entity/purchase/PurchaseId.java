package com.biblio.alpha.entity.purchase;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.entity.OrderEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseId implements Serializable {

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseId)) return false;
        PurchaseId that = (PurchaseId) o;
        return orderEntity.equals(that.orderEntity) &&
                bookEntity.equals(that.bookEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderEntity, bookEntity);
    }
}
