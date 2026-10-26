package com.blayi.transactionaggregation;

import com.blayi.transactionaggregation.model.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class TransactionAggregationApplication {
  public static void main(String[] args) {

    Transaction firstTransaction = new Transaction(
        "id01",
        "Woolworths",
        new BigDecimal("654"),
        LocalDateTime.of(2026, 10, 19, 11, 22));

    System.out.println(firstTransaction.getMerchant());
    System.out.println(firstTransaction.getTransactionId());
    System.out.println(firstTransaction.getAmount());
    System.out.println(firstTransaction.getTransactionDateTime());

    Transaction secondTransaction = new Transaction(
        "id02",
        "Pep",
        new BigDecimal("700"),
        LocalDateTime.of(2026, 10, 23, 12, 27));
    System.out.println(secondTransaction.getMerchant());
    System.out.println(secondTransaction.getTransactionId());
    System.out.println(secondTransaction.getAmount());
    System.out.println(secondTransaction.getTransactionDateTime());

    List<Transaction> transactions = new ArrayList<>();
    transactions.add(firstTransaction);
    transactions.add(secondTransaction);
    System.out.println("Number of transactions: " + transactions.size());

    BigDecimal totalAmount = BigDecimal.ZERO;

    for (Transaction transaction : transactions) {
      System.out.println(transaction.getMerchant());
      totalAmount = totalAmount.add(transaction.getAmount());
    }
    System.out.println("Total amount: " + totalAmount);

  }
}
