package com.starwars.startWarsProject.controller;

import com.starwars.startWarsProject.dto.RequestLocation;
import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.dto.RequestReportTraitor;
import com.starwars.startWarsProject.dto.ResponseRebel;
import com.starwars.startWarsProject.model.*;
import com.starwars.startWarsProject.service.RebelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rebels")
public class RebelController {

    private final RebelService rebelService = new RebelService();
    public RequestRebel newRebel = new RequestRebel(
            "Anakin",
            40, Gender.MALE,
            new Location(45678, 639128, "new earth"),
            new Inventory(2, 10, 6, 12));

    @GetMapping
    public ResponseEntity<List<ResponseRebel>> rebels() {
        if (rebelService.returnRebels().isEmpty()){
            rebelService.addRebel(newRebel);
        }
        return ResponseEntity.ok(ResponseRebel.toResponse(rebelService.returnRebels()));
    }

    @PostMapping
    public ResponseEntity<ResponseRebel> rebels(@RequestBody RequestRebel requestRebel) {
        return ResponseEntity.ok(new ResponseRebel(rebelService.addRebel(requestRebel)));
    }

    @PostMapping("/update-location")
    public ResponseEntity<String> updateLocation(@RequestBody RequestLocation requestLocation) throws IllegalAccessException {
        rebelService.updateLocation(requestLocation);
        return ResponseEntity.ok("Localização atualizada");
    }

    @PostMapping("/report-traitor")
    public ResponseEntity<String> reportRebel(@RequestBody RequestReportTraitor requestReportTraitor) throws IllegalAccessException {
        String reportTraitorMessage = rebelService.reportRebel(requestReportTraitor);
        return ResponseEntity.ok(reportTraitorMessage);
    }
}
