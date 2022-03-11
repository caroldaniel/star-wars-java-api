package com.starwars.startWarsProject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Getter
@Setter
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

    public Integer getTotalInventoryValue() {
        int totalValue = 0;
        for (ItemQuantity item : inventory) {
            totalValue += item.getItem().value * item.getQuantity();
        }
        return totalValue;
    }

    private void addItemQuantity(Items item) {
        Optional<ItemQuantity> updateItem = inventory.stream()
                .filter(listItem -> Objects.equals(listItem.getItem(), item)).findFirst();
        if (updateItem.isPresent()) {
            Integer newQuantity = updateItem.get().getQuantity() + 1;
            updateItem.get().setQuantity(newQuantity);
        }
    }

    private void removeItemQuantity(Items item) {
        Optional<ItemQuantity> updateItem = inventory.stream()
                .filter(listItem -> Objects.equals(listItem.getItem(), item)).findFirst();
        if (updateItem.isPresent()) {
            Integer newQuantity = updateItem.get().getQuantity() - 1;
            updateItem.get().setQuantity(newQuantity);
        }
    }

    public void updateInventory(TradeList receiveItems, TradeList giveItems) {
        for (Items item :
                receiveItems.getItemsList()) {
            addItemQuantity(item);
        }

        for (Items item : giveItems.getItemsList()) {
            removeItemQuantity(item);
        }
    }

    public Boolean canTrade(TradeList giveItems) {
        Boolean canTrade;
        for (ItemQuantity itemQuantity : inventory) {
            int giveQuantity = (int) giveItems.getItemsList()
                    .stream().filter(item -> Objects.equals(item, itemQuantity.getItem())).count();
            if (giveQuantity != 0) {
                canTrade = giveQuantity < itemQuantity.getQuantity();
                if (!canTrade) {
                    return false;
                }
            }
        }
        return true;
    }
}
