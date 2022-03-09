package com.starwars.startWarsProject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Inventory {
    private ArrayList<ItemQuantity> inventory;

    public Inventory(Integer weapon, Integer ammo, Integer water, Integer food){
        ItemQuantity weaponQuantity = new ItemQuantity(Items.WEAPON, weapon);
        ItemQuantity ammoQuantity = new ItemQuantity(Items.AMMO, ammo);
        ItemQuantity waterQuantity = new ItemQuantity(Items.WATER, water);
        ItemQuantity foodQuantity = new ItemQuantity(Items.FOOD, food);

        ArrayList<ItemQuantity> inventoryConstructor = new ArrayList<>();

        inventoryConstructor.add(weaponQuantity);
        inventoryConstructor.add(ammoQuantity);
        inventoryConstructor.add(waterQuantity);
        inventoryConstructor.add(foodQuantity);

        this.inventory = inventoryConstructor;
    }

    public Integer getTradeListValue(List<ItemQuantity> tradeList) {
        int totalValue = 0;
        for (ItemQuantity item: inventory) {
            totalValue += item.getItem().value;
        }
        return totalValue;
    }
}
