package com.company.customerinfo.controller;

import com.company.customerinfo.config.annotation.LogMethodExecutionTime;
import com.company.customerinfo.model.Customer;
import com.company.customerinfo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @LogMethodExecutionTime
    @PostMapping("/customer/save")
    public ResponseEntity<?> save(@RequestBody Customer customer) {
        Customer response = customerService.save(customer);
        return new ResponseEntity<Customer>( response, HttpStatus.OK );
    }

}
