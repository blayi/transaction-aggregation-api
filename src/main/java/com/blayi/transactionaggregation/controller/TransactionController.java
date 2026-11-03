package com.blayi.transactionaggregation.controller;

import com.blayi.transactionaggregation.model.Transaction;
import jakarta.validation.Valid;
import com.blayi.transactionaggregation.service.TransactionAggregationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionAggregationService aggregationService;

    public TransactionController(TransactionAggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping
    public List<Transaction> getTransactions() {
        return aggregationService.getTransactions();
    }

    @PostMapping
public Transaction addTransaction(@Valid @RequestBody Transaction transaction) {
    return aggregationService.addTransaction(transaction);
}

@GetMapping("/summary")
public Map<String, Object> getSummary() {
    Map<String, Object> summary = new HashMap<>();

    summary.put("transactionCount", aggregationService.getTransactions().size());
    summary.put("totalAmount", aggregationService.getTotalAmount());

    return summary;
}
}