package com.starwars.startWarsProject.model;

import com.starwars.startWarsProject.dto.RequestTradeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter @Setter
@AllArgsConstructor
public class Rebel {
    private String name;
    private Number age;
    private Gender gender;
    private Location location;
    private int timesReported;
    private Boolean isTraitor;
    private List<Items> inventory;

    public void wasReported() {
        if (this.timesReported < 3) {
            this.timesReported ++;
        } else {
            this.setIsTraitor(true);
        }
    }

    public void updateInventory(TradeList receiveItems, TradeList giveItems) {
        inventory.removeAll(giveItems.getItemsList());
        inventory.addAll(receiveItems.getItemsList());
    }


}
