package com.starwars.startWarsProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rebel {
    private String name;
    private Number age;
    private Gender gender;
    private Location location;
    private int timesReported;
    private Boolean isTraitor;
    private Inventory inventory;
}
