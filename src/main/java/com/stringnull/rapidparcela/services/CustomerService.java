package com.stringnull.rapidparcela.services;

import com.stringnull.rapidparcela.dto.response.CustomerDTOResponse;
import com.stringnull.rapidparcela.validation.ApiResponse;
import com.stringnull.rapidparcela.dto.request.CustomerDTORequest;
import com.stringnull.rapidparcela.models.Customer;
import com.stringnull.rapidparcela.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ApiResponse<?> getAllCustomer() {
        try {
            List<CustomerDTOResponse> list = customerRepository.findAll().stream().map(entity -> modelMapper.map(entity, CustomerDTOResponse.class)).toList();
            return new ApiResponse<>().success(list);
        } catch (Exception e) {
            return new ApiResponse<>().error("Error getting customer list.");
        }
    }

    public ApiResponse<?> saveCustomer(CustomerDTORequest customer) {
        try {
            Customer saveCustomer = customerRepository.save(modelMapper.map(customer, Customer.class));
            return new ApiResponse<>().success(saveCustomer);
        } catch (DataAccessException dae) {
            return new ApiResponse<>().error(dae.getMostSpecificCause().getMessage());
        }
    }

    public ApiResponse<?> getCustomerById(long i) {
        Customer customer = customerRepository.findById(i).orElse(null);
        if (customer != null)
            return new ApiResponse<>().success(modelMapper.map(customer, CustomerDTOResponse.class));
        else
            return new ApiResponse<>().error("Customer Not found id: " + i);
    }

    public ApiResponse<?> deleteCustomerById(long id) {
        try {
            Customer deleteCustomer = customerRepository.findById(id).orElse(null);
            if (deleteCustomer != null) {
                customerRepository.deleteById(id);
                return new ApiResponse<>().success(modelMapper.map(deleteCustomer, CustomerDTOResponse.class));
            } else {
                return new ApiResponse<>().error("Customer ID not found.");
            }
        } catch (Exception e) {
            return new ApiResponse<>().error("Customer did not delete");
        }
    }

    public ApiResponse<?> updateCustomerById(long id, CustomerDTORequest customer) {
        try {
            Customer existingCustomer = customerRepository.findById(id).orElse(null);

            if (existingCustomer != null) {
                modelMapper.map(customer, existingCustomer);
                var updatedCustomer = customerRepository.save(existingCustomer);
                return new ApiResponse<>()
                        .success(modelMapper.map(updatedCustomer, CustomerDTOResponse.class));
            } else {
                return new ApiResponse<>().error("Customer did not found");
            }
        } catch (Exception e) {
            return new ApiResponse<>().error("Customer did not update: " + e.getMessage());
        }
    }
}
