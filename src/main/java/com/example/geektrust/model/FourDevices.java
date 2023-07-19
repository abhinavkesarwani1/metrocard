package com.example.geektrust.model;

public class FourDevices implements TopUp{
    int pricing;
    int numberOfMonths;

    public FourDevices(int numberOfMonths) {
        this.pricing = 50;
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
