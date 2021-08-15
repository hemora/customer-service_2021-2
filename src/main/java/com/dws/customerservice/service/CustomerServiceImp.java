package com.dws.customerservice.service;

import com.dws.customerservice.dto.Customer;
import com.dws.customerservice.dto.RespuestaApi;
import com.dws.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }

    @Override
    public RespuestaApi createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }

    @Override
    public RespuestaApi updateCustomer(Customer customer, int id) {
        return customerRepository.updateCustomer(customer, id);
    }

    @Override
    public RespuestaApi deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }
}
