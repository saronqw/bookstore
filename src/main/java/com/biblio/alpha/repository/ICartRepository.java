package com.biblio.alpha.repository;

import com.biblio.alpha.entity.CustomerEntity;
import com.biblio.alpha.entity.basket.BasketEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICartRepository extends CrudRepository<BasketEntity, Long> {
    List<BasketEntity> findAllById_CustomerEntity(CustomerEntity customerId);
}
