package com.example.geektrust.service;

import com.example.geektrust.model.Music;
import com.example.geektrust.model.Podcast;
import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.Videos;

public class SubscriptionCreatorService {

    public Subscription getSubscription(String subscription, String subscriptionType) {
        if (subscription.equalsIgnoreCase("MUSIC")) {
            return new Music(subscriptionType);
        } else if (subscription.equalsIgnoreCase("PODCAST")) {
            return new Podcast(subscriptionType);
        } else if (subscription.equalsIgnoreCase("VIDEO")) {
            return new Videos(subscriptionType);
        }
        return null;
    }
}
