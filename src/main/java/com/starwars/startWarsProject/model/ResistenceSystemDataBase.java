package com.starwars.startWarsProject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResistenceSystemDataBase {
    private static List<Rebel> rebelList = new ArrayList<>();

    public void addRebel(Rebel rebel){
        ResistenceSystemDataBase.rebelList.add(rebel);
    }

    public List<Rebel> returnRebels(){
        return ResistenceSystemDataBase.rebelList;
    }

    public Rebel getRebel(String rebelName) throws IllegalAccessException {
        Optional<Rebel> foundRebel = rebelList.stream()
                .filter(rebel -> Objects.equals(rebel.getName(), rebelName)).findFirst();
        if (foundRebel.isPresent()) {
            return foundRebel.get();
        } else {
            throw new IllegalAccessException("Rebelde não encontrado");
        }
    }

    public Double traitorsPercent() {
        List<Rebel> traitorList = getTraitorList();
        return ((double) traitorList.size() / (double) rebelList.size()) * 100;
    }

    public Double rebelsPercent() {
        List<Rebel> trueRebelList = getTrueRebelsList();
        return ((double) trueRebelList.size() / (double) rebelList.size()) * 100;
    }

    public Double resourcePerRebel(Items verifyItem) {
        Double itemCount = 0.0;
        for (Rebel rebel:
             rebelList) {
            for (ItemQuantity item:
                  rebel.getInventory().getInventory()) {
                if (item.getItem() == verifyItem) {
                    itemCount += item.getQuantity();
                }
            }
        }
        return (itemCount / (double) rebelList.size());
    }

    public Double itemsLossPoints() {
        Double totalLostPoint = 0.0;
        for (Rebel rebel:
             rebelList) {
            if (rebel.getIsTraitor()) {
                totalLostPoint += rebel.getInventory().calculateTotalInventoryValue();
            }
        }
        return totalLostPoint;
    }

    private List<Rebel> getTraitorList() {
        return rebelList.stream().filter(rebel -> Objects.equals(rebel.getIsTraitor(), true)).collect(Collectors.toList());
    }

    private List<Rebel> getTrueRebelsList() {
        return rebelList.stream().filter(rebel -> Objects.equals(rebel.getIsTraitor(), false)).collect(Collectors.toList());
    }
}
