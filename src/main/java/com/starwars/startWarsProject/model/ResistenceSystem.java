package com.starwars.startWarsProject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResistenceSystem {
    private static List<Rebel> rebelList = new ArrayList<>();

    public void addRebel(Rebel rebel){
        ResistenceSystem.rebelList.add(rebel);
    }

    public List<Rebel> returnRebels(){
        return ResistenceSystem.rebelList;
    }

    /* Metodo para pegar um rebelde na lista pelo nome, se no futuro gerarmos ids para eles é so mudar o parametro*/
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

    public Double resourcePerRebelPercent(Items verifyItem) {
        Double itemCount = 0.0;
        for (Rebel rebel:
             rebelList) {
            for (Items item:
                  rebel.getInventory()) {
                if (item == verifyItem) {
                    itemCount++;
                }
            }
        }
        return (itemCount / (double) rebelList.size()) * 100;
    }

    private List<Rebel> getTraitorList() {
        return rebelList.stream().filter(rebel -> Objects.equals(rebel.getIsTraitor(), true)).collect(Collectors.toList());
    }

    private List<Rebel> getTrueRebelsList() {
        return rebelList.stream().filter(rebel -> Objects.equals(rebel.getIsTraitor(), false)).collect(Collectors.toList());
    }
}
