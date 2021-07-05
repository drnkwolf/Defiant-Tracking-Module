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

    @GetMapping("{customerId}/{packageId}/package")
    public Package getAPackage(@PathVariable int customerId, @PathVariable int packageId){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if(customerOptional.isPresent()){
            Set<Package> packages = customerOptional.get().getPackages();

            for (Package pack :
                    packages) {
                if (pack.getId() == packageId) {
                    return pack;
                }
            }
        }

        return null;
    }
}
