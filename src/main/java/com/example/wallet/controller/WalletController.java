package com.example.wallet.controller;

import com.example.wallet.model.Transaction;
import com.example.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/balance")
    public double getBalance() {
        return walletService.getBalance();
    }

    @PostMapping("/deposit")
    public double deposit(@RequestParam double amount) {
        return walletService.deposit(amount);
    }

    @PostMapping("/withdraw")
    public double withdraw(@RequestParam double amount) {
        return walletService.withdraw(amount);
    }

    @GetMapping("/history")
    public List<Transaction> getHistory() {
        return walletService.getHistory();
    }
}
