package com.starwars.startWarsProject.controller;

import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.dto.ResponseRebel;
import com.starwars.startWarsProject.model.*;
import com.starwars.startWarsProject.service.RebelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rebels")
public class RebelController {

    private RebelService rebelService = new RebelService();

    public RequestRebel newRebel = new RequestRebel("Anakin", 40, Gender.MALE, new Location(45678, 639128, "new earth"));

    @GetMapping
    public List<ResponseRebel> rebels() {
        if (rebelService.returnRebels().isEmpty()){
            rebelService.addRebel(newRebel);
        }
        return ResponseRebel.toResponse(rebelService.returnRebels());
    }

    @PostMapping
    public ResponseRebel rebels(@RequestBody RequestRebel requestRebel) {
        ResponseRebel responseRebel = new ResponseRebel(rebelService.addRebel(requestRebel));
        return responseRebel;
    }
}
