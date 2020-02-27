package com.biblio.alpha.repository;

import com.biblio.alpha.entity.CustomerEntity;
import com.biblio.alpha.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOrderRepository extends CrudRepository<OrderEntity, Long> {

    List<OrderEntity> findAllByCustomerId(CustomerEntity customerId);
}
