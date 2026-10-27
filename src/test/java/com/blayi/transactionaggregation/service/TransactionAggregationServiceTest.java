package com.blayi.transactionaggregation.service;
import com.blayi.transactionaggregation.model.Transaction;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionAggregationServiceTest {

    @Test
void calculatesTotalAmount() {
    Transaction firstTransaction = new Transaction(
        "id01",
        "Woolworths",
        new BigDecimal("654"),
        LocalDateTime.of(2026, 10, 19, 11, 22)
);

Transaction secondTransaction = new Transaction(
        "id02",
        "Pep",
        new BigDecimal("700"),
        LocalDateTime.of(2026, 10, 23, 12, 27)
);
List<Transaction> transactions =
        List.of(firstTransaction, secondTransaction);

        TransactionAggregationService aggregationService =
        new TransactionAggregationService();

BigDecimal calculatedTotal =
        aggregationService.calculateTotal(transactions);

assertEquals(new BigDecimal("1354"), calculatedTotal);
}
    
}
