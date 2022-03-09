package com.starwars.startWarsProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/* Objeto para limpar o codigo e facilitar a troca*/
@Setter
@Getter
@AllArgsConstructor
public class TradeList {
    private List<Items> itemsList;

    public Integer getValue() {
        int totalValue = 0;
        for (Items item: itemsList) {
            totalValue += item.value;
        }
        return totalValue;
    }

}
