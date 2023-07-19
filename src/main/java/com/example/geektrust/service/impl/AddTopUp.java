package com.example.geektrust.service.impl;

import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.TopUp;
import com.example.geektrust.model.User;
import com.example.geektrust.service.ICommandService;
import com.example.geektrust.service.TopUpCreatorService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AddTopUp implements ICommandService {
    @Override
    public void execute(Map<String, Subscription> userSubscriptions, List<String> parameters,
                        Map<String, LocalDate> userSubscriptionDate, User user, Map<String, TopUp> userTopUp) throws Exception {
        if (userTopUp.containsKey(user.getUserId())) {
            throw new Exception("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
        } else if (!(userSubscriptionDate.containsKey(user.getUserId()))) {
            throw new Exception("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
        } else {
            boolean found = false;
            for (Map.Entry<String, Subscription> map: userSubscriptions.entrySet()) {
                String data[] = map.getKey().split(":");
                if (data[0].equalsIgnoreCase(user.getUserId())) {
                    found = true;
                }
            }
            if (!found) {
                throw new Exception("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
            }
        }
        String topUp = parameters.get(0);
        String numberOfMonths = parameters.get(1);
        TopUpCreatorService topUpCreatorService = new TopUpCreatorService();
        userTopUp.put(user.getUserId(), topUpCreatorService.getTopUpObject(topUp, numberOfMonths));
    }
}
