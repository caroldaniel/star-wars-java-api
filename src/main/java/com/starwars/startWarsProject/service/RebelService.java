package com.starwars.startWarsProject.service;

import com.starwars.startWarsProject.StartWarsProjectApplication;
import com.starwars.startWarsProject.dto.RequestLocation;
import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.dto.RequestReportTraitor;
import com.starwars.startWarsProject.model.Rebel;

import java.util.List;

public class RebelService {

    public Rebel addRebel(RequestRebel requestRebel) {
        Rebel rebel = new Rebel(requestRebel.getName(), requestRebel.getAge(), requestRebel.getGender(), requestRebel.getLocation(), 0, false, requestRebel.getInventory());
        StartWarsProjectApplication.resistenceSystemDataBase.addRebel(rebel);
        return rebel;
    }

    public List<Rebel> returnRebels() {
        return StartWarsProjectApplication.resistenceSystemDataBase.returnRebels();
    }

    public Rebel updateLocation(RequestLocation newLocation) throws IllegalAccessException {
        Rebel rebel = StartWarsProjectApplication.resistenceSystemDataBase.getRebel(newLocation.getName());
        rebel.setLocation(newLocation.toLocation());
        return rebel;
    }

    public String reportRebel(RequestReportTraitor requestReportTraitor) throws IllegalAccessException {
        Rebel reporterRebel = StartWarsProjectApplication.resistenceSystemDataBase.getRebel(requestReportTraitor.getReporter());
        Rebel reportedRebel = StartWarsProjectApplication.resistenceSystemDataBase.getRebel(requestReportTraitor.getTraitorName());
        String traitorReportMessage;
        if (reporterRebel.getIsTraitor()) {
            return "Você é um traidor";
        }

        Integer timesReported = reportedRebel.getTimesReported();
        if (timesReported < 2) {
            StartWarsProjectApplication.resistenceSystemDataBase.getRebel(requestReportTraitor.getTraitorName()).setTimesReported(timesReported + 1);
            traitorReportMessage = requestReportTraitor.getTraitorName() + " foi reportado, mas ainda não é considerado traidor(a)!!!";
        } else {
            StartWarsProjectApplication.resistenceSystemDataBase.getRebel(requestReportTraitor.getTraitorName()).setIsTraitor(true);
            traitorReportMessage = requestReportTraitor.getTraitorName() + " agora é considerado traidor(a)!!!";
        }

        return traitorReportMessage;
    }
}
