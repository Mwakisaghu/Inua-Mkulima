package com.example.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionHandler implements HttpHandler {
    private static final List<Map<String, Object>> transactions = new ArrayList<>();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleRequest(HttpServerExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod().toString())) {
            handleAddTransaction(exchange);
        } else {
            exchange.setStatusCode(405);
            exchange.getResponseSender().send("Method Not Allowed");
        }
    }

    private void handleAddTransaction(HttpServerExchange exchange) throws IOException {
        exchange.getRequestReceiver().receiveFullString((reqExchange, message) -> {
            try {
                Map<String, Object> transaction = objectMapper.readValue(message, Map.class);
                transactions.add(transaction);
                exchange.setStatusCode(201);
                exchange.getResponseSender().send("Transaction recorded successfully");
            } catch (Exception e) {
                exchange.setStatusCode(400);
                exchange.getResponseSender().send("Invalid request");
            }
        });
    }
}
