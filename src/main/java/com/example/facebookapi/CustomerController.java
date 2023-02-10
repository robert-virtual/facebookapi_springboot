package com.example.facebookapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;
    CustomerController(CustomerRepository repo){
       this.customerRepository = repo;
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        try {
            return ResponseEntity.ok(customerRepository.save(customer));
        }catch (Exception e){
           return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all")
    public Iterable<Customer> getAllCustomers(){
        return customerRepository.activeCustomers();
    }
    @GetMapping("/one/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable int id){
        try {
            return ResponseEntity.ok(customerRepository.findById(id));
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Customer>> updateCustomer(@RequestBody Customer customerUpdate,@PathVariable int id){
        try {
            return ResponseEntity.ok(customerRepository.findById(id).map(customer -> {
                customer.setName(customerUpdate.getName());
                customer.setLastname(customerUpdate.getLastname());
                return customerRepository.save(customer);
            }));
        }catch (Exception e){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id){
        try {
            customerRepository.findById(id).map(customer -> {
                customer.setStatus(false);
                return customerRepository.save(customer);
            });
            return ResponseEntity.ok("the customer is now inactive");
        }catch (Exception e){
            return new ResponseEntity<>("Ups, an unexpected error has occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
