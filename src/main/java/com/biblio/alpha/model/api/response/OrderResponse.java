package com.biblio.alpha.model.api.response;

import com.biblio.alpha.entity.OrderEntity;
import com.biblio.alpha.entity.purchase.PurchaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderResponse {

    public OrderResponse(OrderEntity orderEntity) {
        this.orderId = orderEntity.getOrderId();
        this.date = orderEntity.getDate();
        List<PurchaseResponse> purchaseResponses = new ArrayList<>();
        for (PurchaseEntity purchaseEntity : orderEntity.getPurchaseEntityList()) {
            purchaseResponses.add(new PurchaseResponse(purchaseEntity));
        }
        this.purchaseEntityList = purchaseResponses;
    }

    private Long orderId;
    private LocalDateTime date;

    @JsonProperty("order")
    private List<PurchaseResponse> purchaseEntityList;

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

    public List<PurchaseResponse> getPurchaseEntityList() {
        return purchaseEntityList;
    }

    public void setPurchaseEntityList(List<PurchaseResponse> purchaseEntityList) {
        this.purchaseEntityList = purchaseEntityList;
    }
}
