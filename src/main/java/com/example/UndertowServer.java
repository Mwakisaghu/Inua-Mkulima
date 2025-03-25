package com.example;

import io.undertow.Undertow;
import io.undertow.util.Headers;

public class UndertowServer {

    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(8083, "localhost")
                .setHandler(exchange -> {
                    String responseText = "Hello from Undertow!";
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    exchange.getResponseSender().send(responseText);
                })
                .build();
        server.start();
        System.out.println("Server started on http://localhost:8083");
    }
}
