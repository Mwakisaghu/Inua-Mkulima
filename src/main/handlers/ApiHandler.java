package com.example;

import com.example.handlers.AuthHandler;
import com.example.handlers.ProductHandler;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiHandler implements HttpHandler {
    private static final AuthHandler authHandler = new AuthHandler();
    private static final ProductHandler productHandler = new ProductHandler();

    @Override
    public void handleRequest(HttpServerExchange exchange) throws IOException {
        String path = exchange.getRequestPath();
        String method = exchange.getRequestMethod().toString();

        if ("/api/auth/login".equals(path) && "POST".equals(method)) {
            authHandler.handleRequest(exchange);
        } else if ("/api/products".equals(path)) {
            productHandler.handleRequest(exchange);
        } else {
            exchange.setStatusCode(404);
            exchange.getResponseSender().send("Not Found");
        }
    }
}
