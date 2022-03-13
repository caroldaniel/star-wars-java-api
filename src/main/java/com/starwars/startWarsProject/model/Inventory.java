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
            addItem(receivedItem);
        }

        for (ItemQuantity giveItem : giveItems.getItemsList()) {
            removeItem(giveItem);
        }
    }

    private void addItem(ItemQuantity receivedItem) {
        Optional<ItemQuantity> currentItem = inventory.stream().filter(
                item -> Objects.equals(item.getItem(), receivedItem.getItem()
                )).findFirst();
        currentItem.ifPresent(itemQuantity -> itemQuantity.setQuantity(itemQuantity.getQuantity() + receivedItem.getQuantity()));
    }

    private void removeItem(ItemQuantity giveItem) {
        Optional<ItemQuantity> currentItem = inventory.stream().filter(
                item -> Objects.equals(item.getItem(), giveItem.getItem()
                )).findFirst();
        currentItem.ifPresent(itemQuantity -> itemQuantity.setQuantity(itemQuantity.getQuantity() - giveItem.getQuantity()));
    }

    public Boolean hasItemsQuantity(TradeList giveItems) {
        for (ItemQuantity itemInventoryQuantity : inventory) {
            Optional<ItemQuantity> currentItemQuantity = giveItems.getItemsList()
                    .stream().filter(
                            item -> Objects.equals(itemInventoryQuantity.getItem(),item.getItem()
                            )).findFirst();
            if (currentItemQuantity.isPresent()) {
                return  (itemInventoryQuantity.getQuantity() >= currentItemQuantity.get().getQuantity());
            }
        }
        return false;
    }
}
