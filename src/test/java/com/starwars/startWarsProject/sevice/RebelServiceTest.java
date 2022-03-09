package com.starwars.startWarsProject.sevice;

import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.model.*;
import com.starwars.startWarsProject.service.RebelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RebelServiceTest {

    RebelService rebelService = new RebelService();
    public RequestRebel anakin = new RequestRebel("Anakin", 40, Gender.MALE, new Location(45678, 639128, "new earth"));
    public RequestRebel darthVadder = new RequestRebel("DarthVader", 50, Gender.MALE, new Location(45678, 639128, "new earth"));


    @Test
    public void shouldUpdateLocation() throws IllegalAccessException {
        Rebel rebel = rebelService.addRebel(anakin);
        Location newLocation = new Location(123, 456, "Casa do Woigt");
        rebelService.updateLocation(rebel.getName(), newLocation);
        Assertions.assertEquals(newLocation, rebel.getLocation());
    }

    @Test
    public void shouldNotUpdateLocation() {
        Location newLocation = new Location(123, 456, "Casa do Woigt");
        Assertions.assertThrows(IllegalAccessException.class, () -> rebelService.updateLocation("carlos",newLocation));
    }

    @Test
    void shouldReportRebel() throws IllegalAccessException {
        Rebel reporter = rebelService.addRebel(anakin);
        Rebel reported = rebelService.addRebel(darthVadder);
        rebelService.reportRebel(reporter.getName(), reported.getName());
        Assertions.assertEquals(reported.getTimesReported(), 1);
    }

    @Test
    void shouldMarkAsTraitor() throws IllegalAccessException {
        Rebel reporter = rebelService.addRebel(anakin);
        Rebel reported = rebelService.addRebel(darthVadder);
        reported.setTimesReported(3);
        rebelService.reportRebel(reporter.getName(), reported.getName());
        Assertions.assertTrue(reported.getIsTraitor());
    }
//
//    @Test
//    void shouldTradeItems() {
//        Rebel trader = rebelService.addRebel(anakin);
//        Rebel desiredTrader = rebelService.addRebel(darthVadder);
//        TradeList offerItems = new TradeList(new ArrayList<Items>(Collections.(Items.AMMO)));
//        TradeList givenItems = new TradeList(new ArrayList<Items>(Items.FOOD, Items.WATER ));
//    }
}
