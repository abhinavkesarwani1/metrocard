package com.example.geektrust.service;

import com.example.geektrust.model.FourDevices;
import com.example.geektrust.model.TenDevices;
import com.example.geektrust.model.TopUp;

public class TopUpCreatorService {
    public TopUp getTopUpObject(String topUp, String numberOfMonths) {
        if (topUp.equalsIgnoreCase("TEN_DEVICE")) {
            return new TenDevices(Integer.parseInt(numberOfMonths));
        } else if (topUp.equalsIgnoreCase("FOUR_DEVICE")) {
            return new FourDevices(Integer.parseInt(numberOfMonths));
        }
        return null;
    }
}
