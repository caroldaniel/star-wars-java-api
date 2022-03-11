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
        List<Items> givenListItems = new ArrayList<>();
        givenListItems.add(Items.AMMO);
        List<Items> receiverListItems = new ArrayList<>();
        receiverListItems.add(Items.FOOD);
        receiverListItems.add(Items.FOOD);
        receiverListItems.add(Items.FOOD);

        RequestTradeInfo tradeInfo = new RequestTradeInfo(
                "Anakin",
                "DarthVader",
                new TradeList(receiverListItems), new TradeList(givenListItems));
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
        List<Items> givenListItems = new ArrayList<>();
        givenListItems.add(Items.WEAPON);
        givenListItems.add(Items.WEAPON);
        List<Items> receiverListItems = new ArrayList<>();
        receiverListItems.add(Items.FOOD);

        RequestTradeInfo tradeInfo = new RequestTradeInfo(
                "Anakin",
                "DarthVader",
                new TradeList(receiverListItems), new TradeList(givenListItems));
        Assertions.assertThrows(Exception.class, () -> tradeService.tradeItem(tradeInfo));
    }

    @Test
    public void shouldNotTradeGiverDoNotHaveItens() throws IllegalAccessException {
        rebelService.addRebel(anakin);
        rebelService.addRebel(darthVadder);
        List<Items> givenListItems = new ArrayList<>();
        givenListItems.add(Items.WEAPON);
        givenListItems.add(Items.WEAPON);
        givenListItems.add(Items.WEAPON);
        givenListItems.add(Items.WEAPON);
        givenListItems.add(Items.WEAPON);
        List<Items> receiverListItems = new ArrayList<>();
        receiverListItems.add(Items.AMMO);
        receiverListItems.add(Items.AMMO);
        receiverListItems.add(Items.AMMO);
        receiverListItems.add(Items.AMMO);
        receiverListItems.add(Items.AMMO);
        receiverListItems.add(Items.AMMO);
        receiverListItems.add(Items.WATER);

        RequestTradeInfo tradeInfo = new RequestTradeInfo(
                "Anakin",
                "DarthVader",
                new TradeList(receiverListItems), new TradeList(givenListItems));
        Assertions.assertThrows(Exception.class, () -> tradeService.tradeItem(tradeInfo));
    }

    @Test
    public void shouldNotTradeReceiverDoNotHaveItens() throws IllegalAccessException {
        rebelService.addRebel(anakin);
        rebelService.addRebel(darthVadder);
        List<Items> givenListItems = new ArrayList<>();
        givenListItems.add(Items.FOOD);
        givenListItems.add(Items.FOOD);
        givenListItems.add(Items.FOOD);
        List<Items> receiverListItems = new ArrayList<>();
        receiverListItems.add(Items.AMMO);

        RequestTradeInfo tradeInfo = new RequestTradeInfo(
                "Anakin",
                "DarthVader",
                new TradeList(receiverListItems), new TradeList(givenListItems));
        Assertions.assertThrows(Exception.class, () -> tradeService.tradeItem(tradeInfo));
    }

    @Test
    public void shouldNotTradeWithTraitors() throws IllegalAccessException {
        Rebel rebelTrader = rebelService.addRebel(anakin);
        Rebel rebelReceiver = rebelService.addRebel(darthVadder);
        rebelReceiver.setIsTraitor(true);
        List<Items> givenListItems = new ArrayList<>();
        givenListItems.add(Items.AMMO);
        List<Items> receiverListItems = new ArrayList<>();
        receiverListItems.add(Items.FOOD);
        receiverListItems.add(Items.FOOD);
        receiverListItems.add(Items.FOOD);

        RequestTradeInfo tradeInfo = new RequestTradeInfo(
                "Anakin",
                "DarthVader",
                new TradeList(receiverListItems), new TradeList(givenListItems));
        Assertions.assertThrows(Exception.class, () -> tradeService.tradeItem(tradeInfo));
    }
}
