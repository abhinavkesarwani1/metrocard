package com.example.geektrust.service;

import com.example.geektrust.service.impl.Balance;
import com.example.geektrust.service.impl.CheckIn;
import com.example.geektrust.service.impl.PrintSummary;

public class CommandService {
    public ICommandService getCommand(String command) {
        if (command.equalsIgnoreCase("BALANCE")) {
            return new Balance();
        } else if (command.equalsIgnoreCase("CHECK_IN")) {
            return new CheckIn();
        } else if (command.equalsIgnoreCase("PRINT_SUMMARY")) {
            return new PrintSummary();
        }
        return null;
    }
}

