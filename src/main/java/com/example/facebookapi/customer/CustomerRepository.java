package com.example.facebookapi.customer;

import com.example.facebookapi.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    @Query(value = "select * from customer where status = 1",nativeQuery = true)
    Iterable<Customer> activeCustomers();
}
