package com.example.geektrust.service.impl;

import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.Station;
import com.example.geektrust.service.ICommandService;
import com.example.geektrust.service.MetroService;

import java.util.List;
import java.util.Map;

public class Balance implements ICommandService {

    @Override
    public void execute(Map<String, MetroCard> metroCardMap, Map<String, Station> stationMap, List<String> parameters) {
        String metroId = parameters.get(0);
        String balance = parameters.get(1);
        MetroService metroService = new MetroService();
        MetroCard metroCard = metroService.createMetroCard(metroId, Integer.parseInt(balance));
        metroCardMap.put(metroCard.getId(), metroCard);
    }
}
