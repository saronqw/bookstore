package com.biblio.alpha.repository;

import com.biblio.alpha.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends CrudRepository<CustomerEntity, Long> {
    @Query("from CustomerEntity as c where (c.customerId = :id)")
    //CustomerEntity findAllBooksByCustomerId(@Param("id") Long id);

    CustomerEntity findByCustomerId(Long id);
}
//and (:subject in (select a.id from UserEntity b join b.subjects a where b.id= u.id) or :subject=0)"