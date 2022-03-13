package com.starwars.startWarsProject.sevice;

import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.dto.RequestTradeInfo;
import com.starwars.startWarsProject.model.*;
import com.starwars.startWarsProject.service.RebelService;
import com.starwars.startWarsProject.service.TradeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TradeServiceTest {

    RebelService rebelService = new RebelService();
    public RequestRebel anakin = new RequestRebel("Anakin",
            40,
            Gender.MALE,
            new Location(45678, 639128, "new earth"),
            new Inventory(2, 10, 6, 12));
    public RequestRebel darthVadder = new RequestRebel("DarthVader",
            50,
            Gender.MALE,
            new Location(45678, 639128, "new earth"),
            new Inventory(3, 0, 6, 4));

    TradeService tradeService = new TradeService();

    @Test
    public void shouldTrade() throws IllegalAccessException {
        Rebel rebelTrader = rebelService.addRebel(anakin);
        Rebel rebelReceiver = rebelService.addRebel(darthVadder);
        ArrayList<ItemQuantity> givenListItems = new ArrayList<>();
        givenListItems.add(new ItemQuantity(Items.AMMO, 1));
        ArrayList<ItemQuantity> receiverListItems = new ArrayList<>();
        receiverListItems.add(new ItemQuantity(Items.FOOD, 3));

        RequestTradeInfo tradeInfo = new RequestTradeInfo(
                "Anakin",
                new TradeList(givenListItems),
                "DarthVader"
                ,new TradeList(receiverListItems));
        tradeService.tradeItem(tradeInfo);
        Assertions.assertEquals(9, rebelTrader.getInventory().getInventory().get(1).getQuantity());
        Assertions.assertEquals(1, rebelReceiver.getInventory().getInventory().get(1).getQuantity());
        Assertions.assertEquals(15, rebelTrader.getInventory().getInventory().get(3).getQuantity());
        Assertions.assertEquals(1, rebelReceiver.getInventory().getInventory().get(3).getQuantity());
    }

    @Test
    void shouldNotTradePoints() {
        rebelService.addRebel(anakin);
        rebelService.addRebel(darthVadder);
        ArrayList<ItemQuantity> givenListItems = new ArrayList<>();
        givenListItems.add(new ItemQuantity(Items.WEAPON, 2));
        ArrayList<ItemQuantity> receiverListItems = new ArrayList<>();
        receiverListItems.add(new ItemQuantity(Items.FOOD, 1));

        RequestTradeInfo tradeInfo = new RequestTradeInfo(
                "Anakin",
                new TradeList(givenListItems),
                "DarthVader",
                new TradeList(receiverListItems));
        Assertions.assertThrows(Exception.class, () -> tradeService.tradeItem(tradeInfo));
    }

    @Test
    public void shouldNotTradeGiverDoNotHaveItens() throws IllegalAccessException {
        rebelService.addRebel(anakin);
        rebelService.addRebel(darthVadder);
        ArrayList<ItemQuantity> givenListItems = new ArrayList<>();
        givenListItems.add(new ItemQuantity(Items.WEAPON, 5));
        ArrayList<ItemQuantity> receiverListItems = new ArrayList<>();
        receiverListItems.add(new ItemQuantity(Items.AMMO, 6));
        receiverListItems.add(new ItemQuantity(Items.WATER, 1));

        RequestTradeInfo tradeInfo = new RequestTradeInfo(
                "Anakin",
                 new TradeList(givenListItems),
                "DarthVader",
                new TradeList(receiverListItems));
        Assertions.assertThrows(Exception.class, () -> tradeService.tradeItem(tradeInfo));
    }

    @Test
    public void shouldNotTradeReceiverDoNotHaveItens() throws IllegalAccessException {
        rebelService.addRebel(anakin);
        rebelService.addRebel(darthVadder);
        ArrayList<ItemQuantity> givenListItems = new ArrayList<>();
        givenListItems.add(new ItemQuantity(Items.FOOD, 3));
        ArrayList<ItemQuantity> receiverListItems = new ArrayList<>();
        receiverListItems.add(new ItemQuantity(Items.AMMO, 1));

        RequestTradeInfo tradeInfo = new RequestTradeInfo(
                "Anakin",
                new TradeList(givenListItems),
                "DarthVader",
                new TradeList(receiverListItems));
        Assertions.assertThrows(Exception.class, () -> tradeService.tradeItem(tradeInfo));
    }

    @Test
    public void shouldNotTradeWithTraitors() throws IllegalAccessException {
        Rebel rebelTrader = rebelService.addRebel(anakin);
        Rebel rebelReceiver = rebelService.addRebel(darthVadder);
        rebelReceiver.setIsTraitor(true);
        ArrayList<ItemQuantity> givenListItems = new ArrayList<>();
        givenListItems.add(new ItemQuantity(Items.AMMO, 1));
        ArrayList<ItemQuantity> receiverListItems = new ArrayList<>();
        receiverListItems.add(new ItemQuantity(Items.FOOD, 3));

        RequestTradeInfo tradeInfo = new RequestTradeInfo(
                "Anakin",
                new TradeList(givenListItems),
                "DarthVader",
                new TradeList(receiverListItems));
        Assertions.assertThrows(Exception.class, () -> tradeService.tradeItem(tradeInfo));
    }
}
