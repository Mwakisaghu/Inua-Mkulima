package com.example.handlers;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.models.User;

import java.io.IOException;
import java.util.Map;

public class AuthHandler {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void handleLogin(HttpServerExchange exchange, Map<String, String> users) throws IOException {
        exchange.getRequestReceiver().receiveFullString((reqExchange, message) -> {
            try {
                User credentials = objectMapper.readValue(message, User.class);
                String username = credentials.getUsername();
                String password = credentials.getPassword();

                if (users.containsKey(username) && users.get(username).equals(password)) {
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
                    exchange.getResponseSender().send("{\"message\": \"Login successful\"}");
                } else {
                    exchange.setStatusCode(401);
                    exchange.getResponseSender().send("Invalid credentials");
                }
            } catch (Exception e) {
                exchange.setStatusCode(400);
                exchange.getResponseSender().send("Invalid request");
            }
        });
    }
}
