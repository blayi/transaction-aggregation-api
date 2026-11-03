package com.blayi.transactionaggregation.service;

import com.blayi.transactionaggregation.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionAggregationService {

    private final List<Transaction> transactions = new ArrayList<>();

    public Transaction addTransaction(Transaction transaction) {
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public BigDecimal getTotalAmount() {
        return calculateTotal(transactions);
    }

    public BigDecimal calculateTotal(List<Transaction> transactions) {
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {
            totalAmount = totalAmount.add(transaction.getAmount());
        }

        return totalAmount;
    }
}