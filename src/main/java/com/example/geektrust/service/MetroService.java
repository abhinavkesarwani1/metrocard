package com.example.geektrust.service;

import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.PersonType;

import java.util.Map;

public class MetroService {
    public int[] updateCardAmount(MetroCard metroCard, int amount, String personType) {
        int arr[] = new int[3];
        // arr[0] - represents amount deducted from card
        // arr[1] - represents amount discount given on return trip
        // arr[2] - represents amount of recharge done
        boolean isReturnTrip = false;
        arr[0] = amount;
        arr[1] = 0;
        if (metroCard.getPersonTypeIntegerMap().containsKey(PersonType.valueOf(personType))) {
           metroCard.setPersonTypeIntegerMap(personType,
                   metroCard.getPersonTypeIntegerMap().get(PersonType.valueOf(personType)) + 1);
        } else {
            metroCard.setPersonTypeIntegerMap(personType, 1);
        }
        if (metroCard.getPersonTypeIntegerMap().get(PersonType.valueOf(personType)) % 2 == 0) {
            isReturnTrip = true;
        }
        if (isReturnTrip) {
            amount = amount/2;
            arr[0] = amount;
            arr[1] = amount;
        }
        if (metroCard.getBalance() < amount) {
            int temp = metroCard.getBalance() - amount;
            metroCard.setBalance(0);
            arr[2] = -temp;
            return arr;
        } else {
            metroCard.setBalance(metroCard.getBalance() - amount);
            arr[0] = amount;
            return arr;
        }

    }

    public MetroCard createMetroCard(String id, int balance) {
        MetroCard metroCard = new MetroCard(id, balance);
        return metroCard;
    }
}
