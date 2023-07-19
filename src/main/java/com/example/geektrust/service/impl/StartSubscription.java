package com.example.geektrust.service.impl;

import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.TopUp;
import com.example.geektrust.model.User;
import com.example.geektrust.service.ICommandService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ...StartSubscription implements ICommandService {

    final static String DATE_FORMAT = "dd-MM-yyyy";
    @Override
    public void execute(Map<String, Subscription> userSubscriptions, List<String> parameters, Map<String,
            LocalDate> userSubscriptionDate, User user, Map<String, TopUp> userTopUp) throws Exception {
        if (parameters.size() != 1) {
            throw new Exception("INVALID_DATE");
        }
        String date = parameters.get(0);
        if (isDateValid(date)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            userSubscriptionDate.put(user.getUserId(), localDate);
        } else {
            throw new Exception("INVALID_DATE");
        }
    }

    public static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
