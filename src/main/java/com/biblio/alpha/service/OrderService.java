package com.biblio.alpha.service;

import com.biblio.alpha.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> getOrdersByLogin(String login);
}
