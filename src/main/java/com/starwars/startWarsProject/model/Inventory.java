package com.starwars.startWarsProject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Getter @Setter
public class Inventory {
    private ArrayList<ItemQuantity> inventory;

    public Inventory(Integer weapon, Integer ammo, Integer water, Integer food) {
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

    public Integer calculateTotalInventoryValue() {
        int totalValue = 0;
        for (ItemQuantity item : inventory) {
            totalValue += item.getItem().value * item.getQuantity();
        }
        return totalValue;
    }

    public void updateInventory(TradeList receiveItems, TradeList giveItems) {
        for (ItemQuantity receivedItem : receiveItems.getItemsList()) {
            for (ItemQuantity inventoryItem : inventory) {
                if (Objects.equals(receivedItem.getItem(), inventoryItem.getItem())) {
                    inventoryItem.setQuantity(inventoryItem.getQuantity() + receivedItem.getQuantity());
                }
            }
        }

        for (ItemQuantity giveItem : giveItems.getItemsList()) {
            for (ItemQuantity inventoryItem : inventory) {
                if (Objects.equals(giveItem.getItem(), inventoryItem.getItem())) {
                    inventoryItem.setQuantity(inventoryItem.getQuantity() - giveItem.getQuantity());
                }
            }
        }
    }

    public Boolean hasItemsQuantity(TradeList giveItems) {
        for (ItemQuantity itemInventoryQuantity : inventory) {
            for (ItemQuantity itemGivenQuantity : giveItems.getItemsList()) {
                if (Objects.equals(itemGivenQuantity.getItem(), itemInventoryQuantity.getItem())) {
                    return (itemInventoryQuantity.getQuantity() >= itemGivenQuantity.getQuantity());
                }
            }
        }
        return false;
    }
}
