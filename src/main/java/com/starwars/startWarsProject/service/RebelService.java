package com.starwars.startWarsProject.service;

import com.starwars.startWarsProject.StartWarsProjectApplication;
import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.dto.RequestReportTraitor;
import com.starwars.startWarsProject.model.Inventory;
import com.starwars.startWarsProject.model.Items;
import com.starwars.startWarsProject.model.Location;
import com.starwars.startWarsProject.model.Rebel;

import java.util.ArrayList;
import java.util.List;

public class RebelService {

    public Rebel addRebel(RequestRebel requestRebel){
        Rebel rebel = new Rebel(requestRebel.getName(), requestRebel.getAge(), requestRebel.getGender(), requestRebel.getLocation(), 0, false, requestRebel.getInventory());
        StartWarsProjectApplication.resistenceSystemDataBase.addRebel(rebel);
        return rebel;
    };

    public List<Rebel> returnRebels(){
        return StartWarsProjectApplication.resistenceSystemDataBase.returnRebels();
    }

    public Rebel updateLocation(String rebelName, Location newLocation) throws IllegalAccessException {
        Rebel rebel = StartWarsProjectApplication.resistenceSystemDataBase.getRebel(rebelName);
        rebel.setLocation(newLocation);
        return rebel;
    }

    public String reportRebel(RequestReportTraitor requestReportTraitor) throws IllegalAccessException {
        Rebel reporterRebel = StartWarsProjectApplication.resistenceSystemDataBase.getRebel(requestReportTraitor.getReporter());
        Rebel reportedRebel = StartWarsProjectApplication.resistenceSystemDataBase.getRebel(requestReportTraitor.getTraitorName());

        if(reporterRebel.getIsTraitor() == true) { return "Você é um traidor"; }

        Integer timesReported = reportedRebel.getTimesReported();
        if (timesReported < 3) {
            reportedRebel.setTimesReported(timesReported++);
        } else {
            reportedRebel.setIsTraitor(true);
        }
        return "";
    }
}
