package com.starwars.startWarsProject.dto;


import com.starwars.startWarsProject.model.Gender;
import com.starwars.startWarsProject.model.Inventory;
import com.starwars.startWarsProject.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor
public class RequestRebel {
    @NotNull(message = "Missing Information") @NotEmpty(message = "Missing Information") @Length(min = 2)
    private String name;
    private Number age;
    private Gender gender;
    private Location location;
    private Inventory inventory;
}
