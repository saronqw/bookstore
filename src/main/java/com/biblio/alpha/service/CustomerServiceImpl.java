package com.biblio.alpha.service;

import com.biblio.alpha.entity.CustomerEntity;
import com.biblio.alpha.repository.ICustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private ICustomerRepository iCustomerRepository;

    public CustomerServiceImpl(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public List<CustomerEntity> getBooksByCustomerLogin(String login) {
        return iCustomerRepository.findAllByLogin(login);
    }

    @Override
    public Long getIdByLogin(String login) {
        return iCustomerRepository.getIdByLogin(login).getCustomerId();
    }
}
