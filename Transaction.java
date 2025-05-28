package com.example.wallet.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private String type;
    private double amount;

    public Transaction() {}

    public Transaction(LocalDateTime timestamp, String type, double amount) {
        this.timestamp = timestamp;
        this.type = type;
        this.amount = amount;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getType() { return type; }
    public double getAmount() { return amount; }

    public void setId(Long id) { this.id = id; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public void setType(String type) { this.type = type; }
    public void setAmount(double amount) { this.amount = amount; }
}
