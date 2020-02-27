package com.biblio.alpha.repository;

import com.biblio.alpha.entity.CustomerEntity;
import com.biblio.alpha.model.api.response.CustomerProfileResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends CrudRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAllByLogin(String login);

    @Query("from CustomerEntity c where c.login = :login")
    CustomerEntity getIdByLogin(@Param("login") String login);

    @Query("from CustomerEntity c where c.customerId = :id")
    CustomerEntity findByCustomerId(@Param("id") Long id);
}