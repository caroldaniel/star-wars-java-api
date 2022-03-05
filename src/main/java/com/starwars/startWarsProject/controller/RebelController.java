package com.starwars.startWarsProject.controller;

import com.starwars.startWarsProject.dto.RequestRebel;
import com.starwars.startWarsProject.dto.ResponseRebel;
import com.starwars.startWarsProject.model.*;
import com.starwars.startWarsProject.service.RegisterRebelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rebels")
public class RebelController {

    private RegisterRebelService registerRebelService = new RegisterRebelService();

    public RequestRebel newRebel = new RequestRebel("Anakin", 40, Gender.MALE, new Location(45678, 639128, "new earth"));

    @GetMapping
    public List<ResponseRebel> rebels() {
        if (registerRebelService.returnRebels().isEmpty()){
            registerRebelService.addRebel(newRebel);
        }
        return ResponseRebel.toResponse(registerRebelService.returnRebels());
    }

    @PostMapping
    public ResponseRebel rebels(@RequestBody RequestRebel requestRebel) {
        ResponseRebel responseRebel = new ResponseRebel(registerRebelService.addRebel(requestRebel));
        return responseRebel;
    }
}
