package com.biblio.alpha.entity.purchase;

import com.biblio.alpha.entity.BookEntity;
import com.biblio.alpha.entity.OrderEntity;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Validated
@Entity
@Table(name = "purchases")
public class PurchaseEntity {

    public PurchaseEntity() {
    }

    @EmbeddedId
    private PurchaseId id;

    @NotNull(message = "The value must be not null")
    @Min(value = 1, message = "The value must be positive")
    @Column(name = "count")
    private Long count;

    public PurchaseId getId() {
        return id;
    }

    public void setId(PurchaseId id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

