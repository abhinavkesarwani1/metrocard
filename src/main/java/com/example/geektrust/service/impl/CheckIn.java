package com.example.geektrust.service.impl;

import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.PersonType;
import com.example.geektrust.model.Station;
import com.example.geektrust.service.ICommandService;
import com.example.geektrust.service.MetroService;
import com.example.geektrust.service.StationService;

import java.util.List;
import java.util.Map;

public class CheckIn implements ICommandService {
    @Override
    public void execute(Map<String, MetroCard> metroCardMap, Map<String, Station> stationMap, List<String> parameters) {
        MetroService metroService = new MetroService();
        String metroCardId = parameters.get(0);
        String personType = parameters.get(1);
        String stationName = parameters.get(2);
        MetroCard metroCard = metroCardMap.get(metroCardId);
        int[] value = metroService.updateCardAmount(metroCard,
                PersonType.valueOf(personType).getPersonTypeAmount(), personType);
        StationService stationService = new StationService();
        stationService.updateStationBalance(stationMap.get(stationName), personType, value);

    }
}
