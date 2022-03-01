package com.starwars.startWarsProject.model;

import java.util.ArrayList;
import java.util.List;

public class ResistenceSystem {
    private static List<Rebel> rebelList = new ArrayList<>();

    public void addRebel(Rebel rebel){
        ResistenceSystem.rebelList.add(rebel);
    }

    public List<Rebel> returnRebels(){
        return ResistenceSystem.rebelList;
    }

    public void updateLocation(Rebel rebel, Location location){}

    public void reportRebel(){}

    public void itemsNegotiation(){}
}
