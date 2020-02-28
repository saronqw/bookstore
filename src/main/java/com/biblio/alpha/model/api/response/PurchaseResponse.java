package com.biblio.alpha.model.api.response;

import com.biblio.alpha.entity.purchase.PurchaseEntity;
import com.biblio.alpha.model.api.request.BookParamsRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseResponse {

    public PurchaseResponse(PurchaseEntity purchaseEntity) {
        this.bookParamsRequest = new BookParamsRequest(purchaseEntity.getId().getBookEntity());
        this.count = purchaseEntity.getCount();
    }

    @JsonProperty("book")
    private BookParamsRequest bookParamsRequest;
    private Long count;

    public BookParamsRequest getBookParamsRequest() {
        return bookParamsRequest;
    }

    public void setBookParamsRequest(BookParamsRequest bookParamsRequest) {
        this.bookParamsRequest = bookParamsRequest;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
