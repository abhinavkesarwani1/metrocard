package com.example.geektrust.model;

import java.util.HashMap;
import java.util.Map;

public class Videos implements Subscription {
    private SubscriptionType subscriptionType;

    public Videos(String subscriptionType) {
        this.subscriptionType = SubscriptionType.valueOf(subscriptionType.toUpperCase());
    }
    private Map<SubscriptionType, Integer> pricingMap = new HashMap() {{
        put(SubscriptionType.FREE, 0);
        put(SubscriptionType.PERSONAL, 200);
        put(SubscriptionType.PREMIUM, 500);
    }};

    @Override
    public float getPricing() {
        return (float) pricingMap.get(subscriptionType);
    }

    @Override
    public int getSubscriptionTypeNumberOfMonths() {
        return subscriptionType.getNumberOfMonths();
    }
}
