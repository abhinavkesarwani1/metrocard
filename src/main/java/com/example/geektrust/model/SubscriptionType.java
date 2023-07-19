package com.example.geektrust.model;

public enum SubscriptionType {

    FREE(1), PERSONAL(1), PREMIUM(3);
    private final int numberOfMonths;
    SubscriptionType(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

}
