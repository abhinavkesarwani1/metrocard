package com.example.geektrust.service;

import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.Station;

import java.util.List;
import java.util.Map;

public interface ICommandService {
    void execute(Map<String, MetroCard> metroCardMap, Map<String, Station> stationMap, List<String> parameters);
}
