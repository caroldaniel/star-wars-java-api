package com.starwars.startWarsProject.controller;

import com.starwars.startWarsProject.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rebels")
public class RebelController {

    private ResistenceSystem resistenceSystem = new ResistenceSystem();


    public Location rebelLoc = new Location(19802732, 89127389, "Moon");
    public Rebel newRebel = new Rebel("Anakin", 25, Gender.MALE, rebelLoc, 0, false, new ArrayList<>());

    @GetMapping
    public List<Rebel> rebels() {
        resistenceSystem.addRebel(this.newRebel);
        return resistenceSystem.returnRebels();
    }

    @PostMapping
    public void registerRebel(Rebel rebel) {
        resistenceSystem.addRebel(rebel);
    }
}
