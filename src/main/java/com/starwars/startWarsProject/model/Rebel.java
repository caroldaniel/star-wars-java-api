package com.starwars.startWarsProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter @Setter
@AllArgsConstructor
public class Rebel {
    private String name;
    private Number age;
    private Gender gender;
    private Location location;
    private int timesReported;
    private Boolean isTraitor;
    private List<Items> inventory;

    /* Metodo para atualizar a localização*/
    public void updateLocation(Location newLocation) {
        this.location = newLocation;
    }

    /*Metodo para reportar rebelde.
    * Recebe o rebelde que deseja reportar
    * Checa se os timesReportede é menor que 3
    * se sim, acrescenta, se não muda para traidor*/
    public void reportRebel(Rebel reportedRebel) {
        if (reportedRebel.timesReported < 3) {
            reportedRebel.timesReported ++;
        } else {
            reportedRebel.setIsTraitor(true);
        }
    }

    /* Metodo da troca
    * Recebe o rebelde que deseja trocar, e duas listas de trocas
    * Dentro da lista de trocas há o metodo getValue() para pegar o valor total da lista
    * se os valores totais de ambas as listas foram iguais, permite-se a troca, atualizando ambos os inventarios com o
    * metodo updateInventory()
    * caso não seja, retorna uma excessão */
    public void tradeItem(Rebel desiredTrader, TradeList receiveItems, TradeList giveItems) throws IllegalAccessException {
        if (isTraitor || desiredTrader.isTraitor) {
            throw new IllegalAccessException("Estamos entre Traidores");
        } else {
            if (Objects.equals(receiveItems.getValue(), giveItems.getValue())) {
                updateInventory(receiveItems, giveItems);
                desiredTrader.updateInventory(giveItems, receiveItems);
            } else {
                throw new IllegalArgumentException("Troca não permitida");
            }
        }
    }

    /* Metodo que atualiza o inentario */
    private void updateInventory(TradeList receiveItems, TradeList giveItems) {
        inventory.removeAll(giveItems.getItemsList());
        inventory.addAll(receiveItems.getItemsList());
    }


}
