package com.example.geektrust.service;

import com.example.geektrust.service.impl.AddSubscription;
import com.example.geektrust.service.impl.AddTopUp;
import com.example.geektrust.service.impl.PrintRenewalDetails;
import com.example.geektrust.service.impl.StartSubscription;

public class CommandOperator {
    ICommandService getCommandExecutor(String command) {
        if (command.equalsIgnoreCase("START_SUBSCRIPTION")) {
            return new StartSubscription();
        } else if (command.equalsIgnoreCase("ADD_SUBSCRIPTION")) {
            return new AddSubscription();
        } else if (command.equalsIgnoreCase("ADD_TOPUP")) {
            return new AddTopUp();
        } else if (command.equalsIgnoreCase("PRINT_RENEWAL_DETAILS")) {
            return new PrintRenewalDetails();
        }
        return null;
    }
}
