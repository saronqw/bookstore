package com.biblio.alpha.controller;

import com.biblio.alpha.entity.basket.BasketEntity;
import com.biblio.alpha.model.api.response.CartResponse;
import com.biblio.alpha.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cart")
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{login}",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<CartResponse>> getList(@PathVariable String login) {
        return ResponseEntity.ok(cartService.getInstance(login));
    }
}
