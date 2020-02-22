package com.biblio.alpha.service;

import com.biblio.alpha.entity.CustomerEntity;
import com.biblio.alpha.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private ICustomerRepository iCustomerRepository;

    public CustomerServiceImpl(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }


    @Override
    public CustomerEntity getBooksByCustomerId(Long id) {
        return iCustomerRepository.findByCustomerId(id);
    }
}
