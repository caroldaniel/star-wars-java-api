package com.starwars.startWarsProject.controller;

import com.starwars.startWarsProject.model.Gender;
import com.starwars.startWarsProject.model.Location;
import com.starwars.startWarsProject.model.Rebel;
import com.starwars.startWarsProject.model.ResistenceSystem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rebels")
public class RebelController {

    private ResistenceSystem resistenceSystem = new ResistenceSystem();

    public Location rebelLoc = new Location(19802732, 89127389, "Moon");
    public Rebel newRebel = new Rebel("Anakin", 25, Gender.MALE, rebelLoc, false);

    @GetMapping
    public List<Rebel> rebels(){
        resistenceSystem.addRebel(this.newRebel);
        return resistenceSystem.returnRebels();
    }

    @PostMapping
    public void registerRebel(Rebel rebel){
        resistenceSystem.addRebel(rebel);
    }
}
