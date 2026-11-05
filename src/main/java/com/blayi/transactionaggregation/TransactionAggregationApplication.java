package com.blayi.transactionaggregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Transaction Aggregation API",
        version = "1.0",
        description = "API for storing transactions and calculating a transaction summary"
    )
)

@SpringBootApplication
public class TransactionAggregationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionAggregationApplication.class, args);
    }
}