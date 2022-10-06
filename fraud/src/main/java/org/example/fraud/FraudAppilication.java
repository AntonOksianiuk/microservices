package org.example.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FraudAppilication {
    public static void main(String[] args) {
        SpringApplication.run(FraudAppilication.class, args);
    }
}
