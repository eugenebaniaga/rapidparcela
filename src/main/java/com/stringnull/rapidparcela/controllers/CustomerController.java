package com.stringnull.rapidparcela.controllers;

import com.stringnull.rapidparcela.dto.request.CustomerDTORequest;
import com.stringnull.rapidparcela.services.CustomerService;
import com.stringnull.rapidparcela.validation.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path="/list")
    public ResponseEntity<ApiResponse<?>> getAllCustomers() {
       return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping(path="/add")
    public ResponseEntity<ApiResponse<?>> createCustomer(@Valid @RequestBody CustomerDTORequest customer){
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @GetMapping(path="/{id}")
    public ResponseEntity< ApiResponse<?> > getCustomerById(@PathVariable Long id){

        return ResponseEntity.ok(customerService.getCustomerById(id));

    }
    @DeleteMapping(path="/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.deleteCustomerById(id));
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<ApiResponse<?>> updateCustomerById(@PathVariable Long id, @RequestBody CustomerDTORequest customer){
//        customerService.updateCustomerById(id, customer);
//        return ResponseEntity.noContent().build();
        return ResponseEntity.ok(customerService.updateCustomerById(id, customer));
    }

}
