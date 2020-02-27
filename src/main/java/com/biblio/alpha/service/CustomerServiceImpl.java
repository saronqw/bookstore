package com.biblio.alpha.service;

import com.biblio.alpha.entity.CustomerEntity;
import com.biblio.alpha.model.api.response.CustomerProfileResponse;
import com.biblio.alpha.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private ICustomerRepository iCustomerRepository;

    public CustomerServiceImpl(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public List<CustomerEntity> getBooksByCustomerLogin(String login) {
        return iCustomerRepository.findAllByLogin(login);
    }

    @Override
    public Long findIdByLogin(String login) {
        return iCustomerRepository.getIdByLogin(login).getCustomerId();
    }

    @Override
    public CustomerProfileResponse getProfile(String login) {
        return new CustomerProfileResponse(iCustomerRepository.findByCustomerId(findIdByLogin(login)));
    }
}
