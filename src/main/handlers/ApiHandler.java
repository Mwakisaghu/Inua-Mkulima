package com.example;

import com.example.handlers.AuthHandler;
import com.example.handlers.ProductHandler;
import com.example.handlers.TransactionHandler;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import java.io.IOException;

public class ApiHandler implements HttpHandler {
    private static final AuthHandler authHandler = new AuthHandler();
    private static final ProductHandler productHandler = new ProductHandler();
    private static final TransactionHandler transactionHandler = new TransactionHandler();

    @Override
    public void handleRequest(HttpServerExchange exchange) throws IOException {
        String path = exchange.getRequestPath();
        String method = exchange.getRequestMethod().toString();

        if ("/api/auth/login".equals(path) && "POST".equals(method)) {
            authHandler.handleRequest(exchange);
        } else if ("/api/products".equals(path)) {
            productHandler.handleRequest(exchange);
        } else if ("/api/transactions".equals(path) && "POST".equals(method)) {
            transactionHandler.handleRequest(exchange);
        } else {
            exchange.setStatusCode(404);
            exchange.getResponseSender().send("Not Found");
        }
    }
}
