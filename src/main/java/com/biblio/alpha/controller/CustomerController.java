package com.biblio.alpha.controller;

import com.biblio.alpha.entity.CustomerEntity;
import com.biblio.alpha.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{login}",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<CustomerEntity>> getList(@PathVariable String login) {
        return ResponseEntity.ok(customerService.getBooksByCustomerLogin(login));
    }
}
