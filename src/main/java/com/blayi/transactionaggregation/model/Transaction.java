package com.blayi.transactionaggregation.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
        private String transactionId;
        private String merchant;
        private BigDecimal amount;
        private LocalDateTime transactionDateTime;

public Transaction(String transactionId, String merchant, BigDecimal amount, LocalDateTime transactionDateTime) {
        this.transactionId = transactionId;
        this.merchant = merchant;
        this.amount = amount;
        this.transactionDateTime = transactionDateTime;


}
public String getMerchant() {
    return merchant;
}
public BigDecimal getAmount(){
        return  amount;
}
public LocalDateTime getTransactionDateTime(){
        return transactionDateTime;

}
public String getTransactionId(){
        return transactionId;
}

}
