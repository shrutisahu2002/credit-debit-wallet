package com.example.wallet;

import com.example.wallet.service.WalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WalletServiceTest {

    @Autowired
    private WalletService walletService;

    @Test
    void testDeposit() {
        double balance = walletService.deposit(500);
        assertTrue(balance >= 500);
    }

    @Test
    void testWithdraw() {
        walletService.deposit(1000);
        double balance = walletService.withdraw(500);
        assertTrue(balance >= 0);
    }

    @Test
    void testOverWithdraw() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            walletService.withdraw(100000);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testGetBalance() {
        double balance = walletService.getBalance();
        assertTrue(balance >= 0);
    }
}
