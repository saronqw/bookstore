package com.biblio.alpha.service;

import com.biblio.alpha.entity.CustomerEntity;
import com.biblio.alpha.entity.OrderEntity;
import com.biblio.alpha.model.api.response.OrderResponse;
import com.biblio.alpha.repository.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<OrderResponse> getOrdersByLogin(String login) {

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerService.findIdByLogin(login));
        List<OrderResponse> orderResponses = new ArrayList<>();
        List<OrderEntity> orderEntities = new ArrayList<>(iOrderRepository.findAllByCustomerId(customerEntity));
        for (OrderEntity orderEntity : orderEntities) {
            orderResponses.add(new OrderResponse(orderEntity));
        }
        return orderResponses;

        /*CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customerService.findIdByLogin(login));
        return iOrderRepository.findAllByCustomerId(customerEntity);*/
    }
}
