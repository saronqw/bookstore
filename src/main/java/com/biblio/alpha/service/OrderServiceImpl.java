package com.biblio.alpha.service;

import com.biblio.alpha.entity.CustomerEntity;
import com.biblio.alpha.entity.OrderEntity;
import com.biblio.alpha.repository.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private IOrderRepository iOrderRepository;

    private CustomerService customerService;

    public OrderServiceImpl(IOrderRepository iOrderRepository, CustomerService customerService) {
        this.iOrderRepository = iOrderRepository;
        this.customerService = customerService;
    }

    @Override
    public List<OrderEntity> getOrdersByLogin(String login) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerService.getIdByLogin(login));
        return iOrderRepository.findAllByCustomerId(customerEntity);
    }
}
