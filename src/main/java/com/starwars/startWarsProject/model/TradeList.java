package com.starwars.startWarsProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
/* Objeto para limpar o codigo e facilitar a troca*/
@Setter
@Getter
@AllArgsConstructor
public class TradeList {
    private ArrayList<ItemQuantity> itemsList;

    public TradeList(Integer weapon, Integer ammo, Integer water, Integer food) {
        ItemQuantity weaponQuantity = new ItemQuantity(Items.WEAPON, weapon);
        ItemQuantity ammoQuantity = new ItemQuantity(Items.AMMO, ammo);
        ItemQuantity waterQuantity = new ItemQuantity(Items.WATER, water);
        ItemQuantity foodQuantity = new ItemQuantity(Items.FOOD, food);

        ArrayList<ItemQuantity> tradeListConstructor = new ArrayList<>();

        tradeListConstructor.add(weaponQuantity);
        tradeListConstructor.add(ammoQuantity);
        tradeListConstructor.add(waterQuantity);
        tradeListConstructor.add(foodQuantity);

        this.itemsList = tradeListConstructor;
    }

    public Integer getValue() {
        int totalValue = 0;
        for (ItemQuantity item: itemsList) {
            totalValue += item.getQuantity() * item.getItem().value;
        }
        return totalValue;
    }
}
