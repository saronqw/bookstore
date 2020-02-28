package com.biblio.alpha.model.api.response;

import com.biblio.alpha.entity.basket.BasketEntity;
import com.biblio.alpha.model.api.request.BookParamsRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CartResponse {

    public CartResponse(BasketEntity basketEntity) {
        this.bookParamsRequest = new BookParamsRequest(basketEntity.getId().getBookEntity());
        this.count = basketEntity.getCount();
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
