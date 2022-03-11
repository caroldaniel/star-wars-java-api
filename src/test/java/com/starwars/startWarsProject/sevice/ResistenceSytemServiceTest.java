package com.starwars.startWarsProject.sevice;

import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.model.*;
import com.starwars.startWarsProject.service.RebelService;
import com.starwars.startWarsProject.service.ResistenceSystemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResistenceSytemServiceTest {

    RebelService rebelService = new RebelService();
    ResistenceSystemService resistenceSystemService = new ResistenceSystemService();
    public RequestRebel anakin = new RequestRebel("Anakin",
            40,
            Gender.MALE,
            new Location(45678, 639128, "new earth"),
            new Inventory(2, 10, 6, 12));
    public RequestRebel darthVadder = new RequestRebel("DarthVader",
            50,
            Gender.MALE,
            new Location(45678, 639128, "new earth"),
            new Inventory(3, 0, 6, 1));

    @Test
    void shouldBeHalfTraitors() {
        rebelService.addRebel(anakin);
        Rebel traitor = rebelService.addRebel(darthVadder);
        traitor.setIsTraitor(true);
        Double percent = resistenceSystemService.traitorPercent();
        Assertions.assertEquals(50, percent);
    }

    @Test
    void shouldHaveNoTraitors() {
        rebelService.addRebel(anakin);
        rebelService.addRebel(darthVadder);
        Double percent = resistenceSystemService.traitorPercent();
        Assertions.assertEquals(0, percent);
    }

    @Test
    void shouldBeAllRebels() {
        rebelService.addRebel(anakin);
        rebelService.addRebel(darthVadder);
        Double percent = resistenceSystemService.trueRebelPercent();
        Assertions.assertEquals(100, percent);
    }

    @Test
    void shouldBeHalfRebels() {
        rebelService.addRebel(anakin);
        Rebel traitor = rebelService.addRebel(darthVadder);
        traitor.setIsTraitor(true);
        Double percent = resistenceSystemService.trueRebelPercent();
        Assertions.assertEquals(50, percent);
    }

    @Test
    void shouldHaveTwoWeaponsPerRebel() {
        Rebel rebel = rebelService.addRebel(anakin);
        Double percent = resistenceSystemService.resourcePerRebelPercent(Items.WEAPON);
        Assertions.assertEquals(200, percent);
    }

    @Test
    void shouldHaveLost25Points() {
        Rebel traitor = rebelService.addRebel(darthVadder);
        traitor.setIsTraitor(true);
        Double pointsLost = resistenceSystemService.itemsLossPoints();
        Assertions.assertEquals(25, pointsLost);
    }

    @Test
    void shouldHaveLostNoPoints() {
        rebelService.addRebel(anakin);
        Double pointLost = resistenceSystemService.itemsLossPoints();
        Assertions.assertEquals(0, pointLost);
    }
}
