package com.example.geektrust.service;

import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.TopUp;
import com.example.geektrust.model.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriptionService {
    Map<String, Subscription> userSubscriptions;
    Map<String, LocalDate> userSubscriptionDate;
    Map<String, TopUp> userTopUp;
    User user;

    public SubscriptionService() {
        this.userSubscriptions = new HashMap<>();
        this.userSubscriptionDate = new HashMap<>();
        this.userTopUp = new HashMap<>();
        this.user = new User("Abhinav", "abhinav.kesari@gmail.com", "7905319025");
    }

    public void executeCommand(String command, List<String> parameters) {
        try {
            CommandOperator commandOperator = new CommandOperator();
            ICommandService commandService = commandOperator.getCommandExecutor(command);
            commandService.execute(userSubscriptions, parameters, userSubscriptionDate, user, userTopUp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
