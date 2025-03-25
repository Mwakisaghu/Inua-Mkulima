/* package com.example;

import io.undertow.server.HttpServerExchange;
import java.util.HashMap;
import java.util.Map;

import com.example.handlers.AuthHandler; // Import the AuthHandler class
import com.example.handlers.ProductHandler; // Import the ProductHandler class
import com.example.handlers.TransactionHandler; // Import the TransactionHandler class
import com.example.handlers.WalletHandler; // Import the WalletHandler class

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

public class ApiTest {
    private AuthHandler authHandler;
    private ProductHandler productHandler;
    private TransactionHandler transactionHandler;
    private WalletHandler walletHandler;
    private HttpServerExchange exchange;

    @BeforeEach
    void setUp() {
        authHandler = new AuthHandler();
        productHandler = new ProductHandler();
        transactionHandler = new TransactionHandler();
        walletHandler = new WalletHandler();
        exchange = Mockito.mock(HttpServerExchange.class);
    }

    @Test
    void testUserAuthenticationSuccess() {
        Map<String, String> userCredentials = new HashMap<>();
        userCredentials.put("username", "farmer1");
        userCredentials.put("password", "password123");
        
        when(exchange.getRequestMethod().toString()).thenReturn("POST");
        
        assertDoesNotThrow(() -> authHandler.handleRequest(exchange));
    }

    @Test
    void testAddProduct() {
        when(exchange.getRequestMethod().toString()).thenReturn("POST");
        
        assertDoesNotThrow(() -> productHandler.handleRequest(exchange));
    }

    @Test
    void testGetProducts() {
        when(exchange.getRequestMethod().toString()).thenReturn("GET");
        
        assertDoesNotThrow(() -> productHandler.handleRequest(exchange));
    }

    @Test
    void testAddTransaction() {
        when(exchange.getRequestMethod().toString()).thenReturn("POST");
        
        assertDoesNotThrow(() -> transactionHandler.handleRequest(exchange));
    }

    @Test
    void testGetWalletBalance() {
        when(exchange.getRequestMethod().toString()).thenReturn("GET");
        
        assertDoesNotThrow(() -> walletHandler.handleRequest(exchange));
    }
} */