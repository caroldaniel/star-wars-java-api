package com.starwars.startWarsProject.service;

import com.starwars.startWarsProject.StartWarsProjectApplication;
import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.model.Rebel;

public class RebelService {

    public Rebel addRebel(RequestRebel requestRebel){
        Rebel rebel = new Rebel(requestRebel.getName(), requestRebel.getAge(), requestRebel.getGender(), requestRebel.getLocation(), false);
        StartWarsProjectApplication.resistenceSystem.addRebel(rebel);
        return rebel;
    };
}
