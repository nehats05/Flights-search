package com.flightSearch.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.flightSearch.app.controller","com.flightSearch.app.service","com.flightSearch.app.dao"})
@EntityScan("com.flightSearch")
@EnableJpaRepositories("com.flightSearch.app.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
