package com.example.geektrust.service.impl;

import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.TopUp;
import com.example.geektrust.model.User;
import com.example.geektrust.service.ICommandService;
import com.example.geektrust.service.SubscriptionCreatorService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class AddSubscription implements ICommandService {
    @Override
    public void execute(Map<String, Subscription> userSubscriptions, List<String> parameters,
                        Map<String, LocalDate> userSubscriptionDate, User user, Map<String, TopUp> userTopUp) throws Exception {
        String subscriptionStr = parameters.get(0);
        String subscriptionType = parameters.get(1);
        if (!(userSubscriptionDate.containsKey(user.getUserId()))) {
            throw new Exception("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        } else {
            SubscriptionCreatorService subscriptionCreatorService = new SubscriptionCreatorService();
            Subscription subscription = subscriptionCreatorService.getSubscription(subscriptionStr,
                    subscriptionType);
            if (userSubscriptions.containsKey(user.getUserId() + ":" + subscriptionStr.toUpperCase())) {
                throw new Exception("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
            } else {
                userSubscriptions.put(user.getUserId() + ":" + subscriptionStr.toUpperCase(), subscription);
                LocalDate localDate = userSubscriptionDate.get(user.getUserId());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                System.out.println("RENEWAL_REMINDER " + subscriptionStr + " " +
                        formatter.format(localDate.plusMonths(subscription.getSubscriptionTypeNumberOfMonths()).minusDays(10)));
            }
        }
    }
}
