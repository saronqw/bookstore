package com.biblio.alpha.service;

import com.biblio.alpha.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getBooksByCustomerLogin(String login);
    Long getIdByLogin(String login);
}
