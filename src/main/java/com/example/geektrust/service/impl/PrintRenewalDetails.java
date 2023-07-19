package com.example.geektrust.service.impl;

import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.TopUp;
import com.example.geektrust.model.User;
import com.example.geektrust.service.ICommandService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PrintRenewalDetails implements ICommandService {
    @Override
    public void execute(Map<String, Subscription> userSubscriptions, List<String> parameters,
                        Map<String, LocalDate> userSubscriptionDate, User user, Map<String, TopUp> userTopUp)
            throws Exception {
        if (!(userSubscriptionDate.containsKey(user.getUserId()))) {
            throw new Exception("SUBSCRIPTIONS_NOT_FOUND");
        } else {
            boolean found = false;
            for (Map.Entry<String, Subscription> map: userSubscriptions.entrySet()) {
                String data[] = map.getKey().split(":");
                if (data[0].equalsIgnoreCase(user.getUserId())) {
                    found = true;
                }
            }
            if (!found) {
                throw new Exception("SUBSCRIPTIONS_NOT_FOUND");
            }
        }
        float amount = 0;
        for (Map.Entry<String, Subscription> map : userSubscriptions.entrySet()) {
            amount += map.getValue().getPricing(); //* map.getValue().getSubscriptionTypeNumberOfMonths();
        }
        if (userTopUp.containsKey(user.getUserId())) {
            amount += userTopUp.get(user.getUserId()).getPricing() * userTopUp.get(user.getUserId()).numberOfMonths();
        }
        System.out.println("RENEWAL_AMOUNT " + (int) amount);
    }
}
