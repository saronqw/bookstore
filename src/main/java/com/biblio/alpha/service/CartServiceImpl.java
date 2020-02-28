package com.biblio.alpha.service;

import com.biblio.alpha.entity.basket.BasketEntity;
import com.biblio.alpha.model.api.response.CartResponse;
import com.biblio.alpha.repository.ICartRepository;
import com.biblio.alpha.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final ICartRepository iCartRepository;
    private final ICustomerRepository iCustomerRepository;


    public CartServiceImpl(ICartRepository iCartRepository, ICustomerRepository iCustomerRepository) {
        this.iCartRepository = iCartRepository;
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public List<CartResponse> getInstance(String login) {
        List<CartResponse> cartNew = new ArrayList<>();
        List<BasketEntity> cartCurrent = new ArrayList<>(iCartRepository.findAllById_CustomerEntity(iCustomerRepository.getIdByLogin(login)));
        for (BasketEntity basketEntity : cartCurrent) {
            cartNew.add(new CartResponse(basketEntity));
        }
        return cartNew;
    }
}
