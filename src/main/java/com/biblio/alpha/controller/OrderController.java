package com.biblio.alpha.controller;

import com.biblio.alpha.model.api.response.OrderResponse;
import com.biblio.alpha.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{login}",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<OrderResponse>> getOrdersByLogin(@PathVariable String login) {
        return ResponseEntity.ok(orderService.getOrdersByLogin(login));
    }
}
