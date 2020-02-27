package com.biblio.alpha.entity;

import com.biblio.alpha.entity.purchase.PurchaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Validated
@Entity
@Table(name = "orders")
public class OrderEntity {

    public OrderEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", updatable = false, nullable = false)
    private Long orderId;

    @CreatedDate
    @PastOrPresent
    @NotNull(message = "The value must be not null")
    @Column(name = "date")
    private LocalDateTime date;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private CustomerEntity customerId;

    @OneToMany(mappedBy = "id.orderEntity", cascade = CascadeType.ALL)
    private List<PurchaseEntity> purchaseEntityList = new ArrayList<>();

    public List<PurchaseEntity> getPurchaseEntityList() {
        return purchaseEntityList;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public CustomerEntity getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerEntity customerId) {
        this.customerId = customerId;
    }

    public void setPurchaseEntityList(List<PurchaseEntity> purchaseEntityList) {
        this.purchaseEntityList = purchaseEntityList;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", customerId=" + customerId +
                '}';
    }
}
