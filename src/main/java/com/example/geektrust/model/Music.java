package com.example.geektrust.model;

import java.util.HashMap;
import java.util.Map;

public class Music implements Subscription {
    private SubscriptionType subscriptionType;

    public Music(String subscriptionType) {
        this.subscriptionType = SubscriptionType.valueOf(subscriptionType.toUpperCase());
    }
    private Map<SubscriptionType, Integer> pricingMap = new HashMap() {{
        put(SubscriptionType.FREE, 0);
        put(SubscriptionType.PERSONAL, 100);
        put(SubscriptionType.PREMIUM, 250);
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
