package com.blayi.transactionaggregation.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Transaction {
@NotBlank(message = "Transaction ID is required")
private String transactionId;

@NotBlank(message = "Merchant is required")
private String merchant;

@NotNull(message = "Amount is required")
@DecimalMin(value = "0.01", message = "Amount must be greater than zero")
private BigDecimal amount;

@NotNull(message = "Transaction date and time are required")
private LocalDateTime transactionDateTime;

public Transaction() {
}

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

public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
}

public void setMerchant(String merchant) {
    this.merchant = merchant;
}

public void setAmount(BigDecimal amount) {
    this.amount = amount;
}

public void setTransactionDateTime(LocalDateTime transactionDateTime) {
    this.transactionDateTime = transactionDateTime;
}

}
