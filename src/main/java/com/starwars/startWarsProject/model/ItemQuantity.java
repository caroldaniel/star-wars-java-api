package com.starwars.startWarsProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ItemQuantity {
    private Items item;
    private Integer quantity;
}
