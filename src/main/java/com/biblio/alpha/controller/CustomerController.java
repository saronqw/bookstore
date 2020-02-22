package com.biblio.alpha.controller;

import com.biblio.alpha.service.BookService;
import com.biblio.alpha.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}",
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> getList(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getBooksByCustomerId(id));
    }
}
