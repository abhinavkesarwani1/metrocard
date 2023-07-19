package com.example.geektrust.service.impl;

import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.PersonType;
import com.example.geektrust.model.Station;
import com.example.geektrust.service.ICommandService;

import java.util.List;
import java.util.Map;

public class PrintSummary implements ICommandService {
    @Override
    public void execute(Map<String, MetroCard> metroCardMap, Map<String, Station> stationMap, List<String> parameters) {
//        TOTAL_COLLECTION CENTRAL 300 0
//        PASSENGER_TYPE_SUMMARY
//        ADULT 1
//        SENIOR_CITIZEN 1
//        TOTAL_COLLECTION AIRPORT  403 100
//        PASSENGER_TYPE_SUMMARY
//        ADULT 2
//        KID 2
        for (Map.Entry<String, Station> stationEntry : stationMap.entrySet()) {
            Station station = stationEntry.getValue();
            System.out.println("TOTAL_COLLECTION " + station.getName() + " " + station.getAmount() + " " +
                    station.getDiscountAmount());
            System.out.println("PASSENGER_TYPE_SUMMARY");
            for (Map.Entry<PersonType, Integer> map : station.getPersonTypeIntegerMap().entrySet()) {
                System.out.println(map.getKey().name() + " " + map.getValue());
            }
        }
    }
}
