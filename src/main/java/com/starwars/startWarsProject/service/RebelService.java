package com.starwars.startWarsProject.service;

import com.starwars.startWarsProject.StartWarsProjectApplication;
import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.model.Items;
import com.starwars.startWarsProject.model.Location;
import com.starwars.startWarsProject.model.Rebel;
import com.starwars.startWarsProject.model.TradeList;

import java.util.ArrayList;
import java.util.List;

public class RebelService {

    public Rebel addRebel(RequestRebel requestRebel){
        Rebel rebel = new Rebel(requestRebel.getName(), requestRebel.getAge(), requestRebel.getGender(), requestRebel.getLocation(), 0, false, new ArrayList<Items>());
        StartWarsProjectApplication.resistenceSystem.addRebel(rebel);
        return rebel;
    };

    public List<Rebel> returnRebels(){
        return StartWarsProjectApplication.resistenceSystem.returnRebels();
    }

    public Rebel updateLocation(String rebelName, Location newLocation) throws IllegalAccessException {
        Rebel rebel = StartWarsProjectApplication.resistenceSystem.getRebel(rebelName);
        rebel.updateLocation(newLocation);
        return rebel;
    }

    public void reportRebel(String reporterName, String reportedName) throws IllegalAccessException {
        Rebel reporterRebel = StartWarsProjectApplication.resistenceSystem.getRebel(reporterName);
        Rebel reportedRebel = StartWarsProjectApplication.resistenceSystem.getRebel(reportedName);
        reporterRebel.reportRebel(reportedRebel);
    }

    public void tradeItems(String traderName, String desiredTraderName, TradeList receiveItems, TradeList giveItems) throws IllegalAccessException {
        Rebel trader = StartWarsProjectApplication.resistenceSystem.getRebel(traderName);
        Rebel desiredTrader = StartWarsProjectApplication.resistenceSystem.getRebel(desiredTraderName);
        trader.tradeItem(desiredTrader, receiveItems, giveItems);
    }





}
