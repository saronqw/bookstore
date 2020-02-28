package com.biblio.alpha.service;

import com.biblio.alpha.model.api.response.CartResponse;

import java.util.List;

public interface CartService {
    List<CartResponse> getInstance(String login);
}
