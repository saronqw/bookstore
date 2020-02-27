package com.biblio.alpha.service;

import com.biblio.alpha.entity.CustomerEntity;
import com.biblio.alpha.model.api.response.CustomerProfileResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getBooksByCustomerLogin(String login);
    Long findIdByLogin(String login);
    CustomerProfileResponse getProfile(String login);
}
