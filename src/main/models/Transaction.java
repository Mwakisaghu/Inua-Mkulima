package com.example.models;

public class Transaction {
    private String farmerId;
    private String productId;
    private int quantity;
    private double amount;

    public Transaction() {}

    public Transaction(String farmerId, String productId, int quantity, double amount) {
        this.farmerId = farmerId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}