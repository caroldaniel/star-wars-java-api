package com.starwars.startWarsProject.controller;

import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.dto.RequestReportTraitor;
import com.starwars.startWarsProject.dto.ResponseRebel;
import com.starwars.startWarsProject.model.*;
import com.starwars.startWarsProject.service.RebelService;
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
    public List<ResponseRebel> rebels() {
        if (rebelService.returnRebels().isEmpty()){
            rebelService.addRebel(newRebel);
        }
        return ResponseRebel.toResponse(rebelService.returnRebels());
    }

    @PostMapping
    public ResponseRebel rebels(@RequestBody RequestRebel requestRebel) {
        return new ResponseRebel(rebelService.addRebel(requestRebel));
    }

    @PostMapping("/report-traitor")
    public String reportRebel(@RequestBody RequestReportTraitor requestReportTraitor) throws IllegalAccessException {
        String reportTraitorMessage = rebelService.reportRebel(requestReportTraitor);
        return reportTraitorMessage;
    }
}
