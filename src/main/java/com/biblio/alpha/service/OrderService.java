package com.biblio.alpha.service;

import com.biblio.alpha.model.api.response.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getOrdersByLogin(String login);
}
