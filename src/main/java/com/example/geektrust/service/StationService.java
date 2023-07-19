package com.example.geektrust.service;

import com.example.geektrust.model.PersonType;
import com.example.geektrust.model.Station;

public class StationService {
    public void updateStationBalance(Station station, String personType, int[] amountsDeducted) {
        if (station.getPersonTypeIntegerMap().containsKey(PersonType.valueOf(personType))) {
            int personTypeCount = station.getPersonTypeIntegerMap().get(PersonType.valueOf(personType));
            station.getPersonTypeIntegerMap().put(PersonType.valueOf(personType), ++personTypeCount);
//            personTypeCount = station.getPersonTypeIntegerMap().get(PersonType.valueOf(personType));
        } else {
            station.getPersonTypeIntegerMap().put(PersonType.valueOf(personType), 1);
        }
        int stationSum = station.getAmount();
        int discountAmount = station.getDiscountAmount();
        int addServiceCharge = amountsDeducted[2] != 0 ? (int) (amountsDeducted[2] * 0.02) : 0;
        // arr[0] - represents amount deducted from card
        // arr[1] - represents amount discount given on return trip
        // arr[2] - represents amount of recharge done

//        int sumToBeAdded = addServiceCharge[0] > 0 ? addServiceCharge[0] :
//                addServiceCharge[1] > 0 ? addServiceCharge[1] : PersonType.valueOf(personType).getPersonTypeAmount();
//        if (addServiceCharge[0] < 0) {
//            sumToBeAdded += (int) (0.02 * Math.abs(addServiceCharge[0]));
//        }
//        if (personTypeCount % 2 == 0) {
//            sumToBeAdded = PersonType.valueOf(personType).getPersonTypeAmount()/2;
//            if (addServiceCharge != -1) {
//                sumToBeAdded += (int) (0.02 * addServiceCharge/2);
//            }
//            discountAmount += PersonType.valueOf(personType).getPersonTypeAmount()/2;
//        } else {
//            sumToBeAdded = PersonType.valueOf(personType).getPersonTypeAmount();
//            if (addServiceCharge != -1) {
//                sumToBeAdded += (int) (0.02 * addServiceCharge);
//            }
//        }
        station.setAmount(stationSum + amountsDeducted[0] + addServiceCharge);
        station.setDiscountAmount(discountAmount + amountsDeducted[1]);
    }
}
