package com.biblio.alpha.service;

import com.biblio.alpha.entity.CustomerEntity;

public interface CustomerService {
    CustomerEntity getBooksByCustomerId(Long id);
}
