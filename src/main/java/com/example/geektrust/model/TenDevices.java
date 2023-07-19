package com.example.geektrust.model;

public class TenDevices implements TopUp{
    int pricing;
    int numberOfMonths;

    public TenDevices(int numberOfMonths) {
        this.pricing = 100;
        this.numberOfMonths = numberOfMonths;
    }
    @Override
    public int getPricing() {
        return pricing;
    }

    @Override
    public int numberOfMonths() {
        return numberOfMonths;
    }
}
