package org.example.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void register(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        // todo: check if customer is fraudster
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse =
                restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}",
                        FraudCheckResponse.class, customer.getId());


        // todo: send notofication
    }
}
