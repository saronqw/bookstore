package com.biblio.alpha.entity.purchase;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.entity.OrderEntity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;

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
