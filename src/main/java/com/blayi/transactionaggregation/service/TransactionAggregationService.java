package com.blayi.transactionaggregation.service;
import com.blayi.transactionaggregation.model.Transaction;
import java.math.BigDecimal;
import java.util.List;

public class TransactionAggregationService {
    public BigDecimal calculateTotal(List<Transaction> transactions) {
    BigDecimal totalAmount = BigDecimal.ZERO;

    for (Transaction transaction : transactions) {
        totalAmount = totalAmount.add(transaction.getAmount());
    }

    return totalAmount;
}
    
}
