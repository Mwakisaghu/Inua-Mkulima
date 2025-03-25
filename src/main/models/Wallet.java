package com.example.models;

public class Wallet {
    private String farmerId;
    private double balance;

    public Wallet() {}

    public Wallet(String farmerId, double balance) {
        this.farmerId = farmerId;
        this.balance = balance;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}