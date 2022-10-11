package org.example.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.amqp.RabbitMQMessageProducers;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "org.example.notification",
                "org.example.amqp"
        }
)
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {

        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducers producers,
//                                        NotificationConfig notificationConfig) {
//        return args -> {
//            for (int i = 0; i < 10000; i++) {
//                producers.publish(new Person(true, 18),
//                        notificationConfig.getInternalExchange(),
//                        notificationConfig.getInternalNotificationRoutingKey());
//            }
//        };
//    }
//
//    @AllArgsConstructor
//    @Data
//    class Person {
//        Boolean fraudCheckResponse;
//        Integer customerId;
//    }
}
