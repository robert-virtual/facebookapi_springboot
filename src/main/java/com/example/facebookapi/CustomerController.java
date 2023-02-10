package com.example.facebookapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
    @GetMapping("/all")
    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
}
