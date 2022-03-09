package com.starwars.startWarsProject.service;

import com.starwars.startWarsProject.StartWarsProjectApplication;
import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.model.Items;
import com.starwars.startWarsProject.model.Location;
import com.starwars.startWarsProject.model.Rebel;

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
}
