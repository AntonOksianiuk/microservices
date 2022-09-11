package org.example.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public void register(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
    }
}
