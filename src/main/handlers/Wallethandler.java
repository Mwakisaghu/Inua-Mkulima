package com.example.handlers;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WalletHandler implements HttpHandler {
    private static final Map<String, Double> wallets = new HashMap<>();

    static {
        wallets.put("farmer1", 1000.0);
        wallets.put("farmer2", 500.0);
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod().toString())) {
            handleGetWalletBalance(exchange);
        } else {
            exchange.setStatusCode(405);
            exchange.getResponseSender().send("Method Not Allowed");
        }
    }

    private void handleGetWalletBalance(HttpServerExchange exchange) throws IOException {
        String path = exchange.getRequestPath();
        String farmerId = path.replace("/api/wallet/", "");
        
        Double balance = wallets.getOrDefault(farmerId, 0.0);
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
        exchange.getResponseSender().send("{\"balance\": " + balance + "}");
    }
}
