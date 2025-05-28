package com.example.wallet.service;

import com.example.wallet.model.Transaction;
import com.example.wallet.model.Wallet;
import com.example.wallet.repository.TransactionRepository;
import com.example.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public double getBalance() {
        Wallet wallet = walletRepository.findById(1L).orElse(new Wallet());
        return wallet.getBalance();
    }

    public double deposit(double amount) {
        Wallet wallet = walletRepository.findById(1L).orElse(new Wallet());
        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);
        transactionRepository.save(new Transaction(LocalDateTime.now(), "CREDIT", amount));
        return wallet.getBalance();
    }

    public double withdraw(double amount) {
        Wallet wallet = walletRepository.findById(1L).orElse(new Wallet());
        if (wallet.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        wallet.setBalance(wallet.getBalance() - amount);
        walletRepository.save(wallet);
        transactionRepository.save(new Transaction(LocalDateTime.now(), "DEBIT", amount));
        return wallet.getBalance();
    }

    public List<Transaction> getHistory() {
        return transactionRepository.findAll();
    }
}
