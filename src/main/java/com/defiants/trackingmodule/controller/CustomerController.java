package com.defiants.trackingmodule.controller;

import com.defiants.trackingmodule.model.Customer;
import com.defiants.trackingmodule.model.Package;
import com.defiants.trackingmodule.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("{customerId}/package")
    public Set<Package> getPackages(@PathVariable int customerId){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isPresent()){
            return customerOptional.get().getPackages();
        }

        return null;
    }
}
