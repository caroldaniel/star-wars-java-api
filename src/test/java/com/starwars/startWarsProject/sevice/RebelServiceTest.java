package com.starwars.startWarsProject.sevice;

import com.starwars.startWarsProject.dto.RequestLocation;
import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.dto.RequestReportTraitor;
import com.starwars.startWarsProject.model.Gender;
import com.starwars.startWarsProject.model.Inventory;
import com.starwars.startWarsProject.model.Location;
import com.starwars.startWarsProject.model.Rebel;
import com.starwars.startWarsProject.service.RebelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RebelServiceTest {

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
            new Inventory(3, 0, 6, 1));

    @Test
    public void shouldUpdateLocation() throws IllegalAccessException {
        Rebel rebel = rebelService.addRebel(anakin);
        RequestLocation newLocation = new RequestLocation("Anakin",123, 456, "Casa do Woigt");
        rebelService.updateLocation(newLocation);
        Assertions.assertEquals(newLocation.getLatitude(), rebel.getLocation().getLatitude());
        Assertions.assertEquals(newLocation.getLongitude(), rebel.getLocation().getLongitude());
        Assertions.assertEquals(newLocation.getBaseName(), rebel.getLocation().getBaseName());
    }

    @Test
    public void shouldNotUpdateLocation() {
        RequestLocation newLocation = new RequestLocation("carlos", 123, 456, "Casa do Woigt");
        Assertions.assertThrows(IllegalAccessException.class, () -> rebelService.updateLocation(newLocation));
    }

    @Test
    void shouldReportRebel() throws IllegalAccessException {
        Rebel reporter = rebelService.addRebel(anakin);
        Rebel reported = rebelService.addRebel(darthVadder);
        RequestReportTraitor requestReportTraitor = new RequestReportTraitor(reported.getName(), reporter.getName());
        rebelService.reportRebel(requestReportTraitor);
        Assertions.assertEquals(reported.getTimesReported(), 1);
    }

    @Test
    void shouldMarkAsTraitor() throws IllegalAccessException {
        Rebel reporter = rebelService.addRebel(anakin);
        Rebel reported = rebelService.addRebel(darthVadder);
        reported.setTimesReported(3);
        RequestReportTraitor requestReportTraitor = new RequestReportTraitor(reporter.getName(), reported.getName());
        rebelService.reportRebel(requestReportTraitor);
        Assertions.assertTrue(reported.getIsTraitor());
    }
}
