package com.starwars.startWarsProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class Inventory {
    private List<ItemQuantity> inventory;

    public Integer getValue() {
        int totalValue = 0;
        for (ItemQuantity item: inventory) {
            totalValue += item.getItem().value;
        }
        return totalValue;
    }
}
