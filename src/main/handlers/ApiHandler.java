package com.example;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.handlers.AuthHandler;

import java.io.IOException;
import java.util.*;

public class ApiHandler implements HttpHandler {
    private static final Map<String, String> users = new HashMap<>();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        users.put("farmer1", "password123");
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws IOException {
        String path = exchange.getRequestPath();
        String method = exchange.getRequestMethod().toString();

        if ("/api/auth/login".equals(path) && "POST".equals(method)) {
            AuthHandler.handleLogin(exchange, users);
        } else {
            exchange.setStatusCode(404);
            exchange.getResponseSender().send("Not Found");
        }
    }
}
