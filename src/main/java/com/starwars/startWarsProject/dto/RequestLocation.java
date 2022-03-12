package com.starwars.startWarsProject.dto;

import com.starwars.startWarsProject.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RequestLocation {
    private String name;
    private Number latitude;
    private Number longitude;
    private String baseName;

    public Location toLocation() {
        return new Location(
                this.latitude,
                this.longitude,
                this.baseName
        );
    }
}
