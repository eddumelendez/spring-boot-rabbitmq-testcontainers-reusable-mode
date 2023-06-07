package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.RabbitMQContainer;

public class ConsumerApplicationTests {

    public static void main(String[] args) {
        SpringApplication.from(ConsumerApplication::main)
                .with(ContainerConfiguration.class)
                .run(args);
    }

    @TestConfiguration
    static class ContainerConfiguration {

        @Bean
        @ServiceConnection
        @RestartScope
        RabbitMQContainer rabbitmqContainer() {
            return new RabbitMQContainer("rabbitmq:3.11-alpine")
                    .withReuse(true);
        }

    }

}
