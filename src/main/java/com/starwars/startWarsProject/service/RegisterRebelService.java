package com.starwars.startWarsProject.service;

import com.starwars.startWarsProject.StartWarsProjectApplication;
import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.model.Items;
import com.starwars.startWarsProject.model.Rebel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterRebelService {

    public Rebel addRebel(RequestRebel requestRebel){
        Rebel rebel = new Rebel(requestRebel.getName(), requestRebel.getAge(), requestRebel.getGender(), requestRebel.getLocation(), 0, false, new ArrayList<Items>());
        StartWarsProjectApplication.resistenceSystemDataBase.addRebel(rebel);
        return rebel;
    };

    public List<Rebel> returnRebels(){
        return StartWarsProjectApplication.resistenceSystemDataBase.returnRebels();
    }
}
