package com.biblio.alpha.entity.basket;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
@Entity
@Table(name = "baskets")
public class BasketEntity {

    public BasketEntity() {
    }

    @EmbeddedId
    private BasketId id;

    @Column(name = "count")
    @Min(value = 1, message = "The value must be positive")
    @NotNull(message = "The value must be not null")
    private Long count;

    public BasketId getId() {
        return id;
    }

    public void setId(BasketId id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

