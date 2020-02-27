package com.biblio.alpha.repository;

import com.biblio.alpha.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends CrudRepository<CustomerEntity, Long> {
    //@Query("from CustomerEntity as c left join OrderEntity o on c.customerId=o.customerId")

    List<CustomerEntity> findAllByLogin(String login);

    @Query("from CustomerEntity c where c.login = :login")
    CustomerEntity getIdByLogin(@Param("login") String login);
}