package com.example.handlers;

import com.example.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProductHandler implements HttpHandler {
    private static final List<Product> products = new ArrayList<>();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleRequest(HttpServerExchange exchange) throws IOException {
        String method = exchange.getRequestMethod().toString();
        
        if ("POST".equals(method)) {
            handleAddProduct(exchange);
        } else if ("GET".equals(method)) {
            handleGetProducts(exchange);
        } else {
            exchange.setStatusCode(405);
            exchange.getResponseSender().send("Method Not Allowed");
        }
    }

    private void handleAddProduct(HttpServerExchange exchange) throws IOException {
        exchange.getRequestReceiver().receiveFullString((reqExchange, message) -> {
            try {
                Map<String, Object> productData = objectMapper.readValue(message, Map.class);
                String id = UUID.randomUUID().toString();
                String name = (String) productData.get("name");
                double price = Double.parseDouble(productData.get("price").toString());

                Product product = new Product(id, name, price);
                products.add(product);

                exchange.setStatusCode(201);
                exchange.getResponseSender().send("Product added successfully");
            } catch (Exception e) {
                exchange.setStatusCode(400);
                exchange.getResponseSender().send("Invalid request");
            }
        });
    }

    private void handleGetProducts(HttpServerExchange exchange) throws IOException {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
        exchange.getResponseSender().send(objectMapper.writeValueAsString(products));
    }
}