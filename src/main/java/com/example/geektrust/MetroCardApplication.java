package com.example.geektrust;

import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.Station;
import com.example.geektrust.service.CommandService;
import com.example.geektrust.service.ICommandService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MetroCardApplication {
    Map<String, MetroCard> metroCardMap;
    Map<String, Station> stationMap;

    MetroCardApplication() {
        this.metroCardMap = new HashMap<>();
        this.stationMap = new LinkedHashMap() {{
            put("CENTRAL", new Station("CENTRAL"));
            put("AIRPORT", new Station("AIRPORT"));
        }};
    }

    void commandExecutor(String command, List<String> parameters) {
        try {
            CommandService commandService = new CommandService();
            ICommandService commandExecute = commandService.getCommand(command);
            commandExecute.execute(metroCardMap, stationMap, parameters);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
