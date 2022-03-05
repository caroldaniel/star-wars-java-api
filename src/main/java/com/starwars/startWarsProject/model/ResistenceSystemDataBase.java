package com.starwars.startWarsProject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ResistenceSystemDataBase {
    private static List<Rebel> rebelList = new ArrayList<>();

    public void addRebel(Rebel rebel){
        ResistenceSystemDataBase.rebelList.add(rebel);
    }

    public List<Rebel> returnRebels(){
        return ResistenceSystemDataBase.rebelList;
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
}
