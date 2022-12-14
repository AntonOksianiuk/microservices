package org.example.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.clients.fraud.FraudClient;
import org.example.clients.notification.NotificationClient;
import org.example.communicate.FraudCheckResponse;
import org.example.communicate.Notification;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void register(CustomerRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        // todo: check if customer is fraudster
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudulent()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: send notification
        log.info("new notification, customerId = " + customer.getId() + ", fraudResponse = " + fraudCheckResponse.isFraudulent());
        notificationClient.sendNotification(new Notification(customer.getId(), fraudCheckResponse.isFraudulent()));
    }
}
