package com.example.booksManager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class BooksManagerSettingsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksManagerSettingsServiceApplication.class, args);
    }

}
