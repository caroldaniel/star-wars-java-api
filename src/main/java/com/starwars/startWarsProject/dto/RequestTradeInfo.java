package com.starwars.startWarsProject.dto;

import com.starwars.startWarsProject.model.Inventory;
import com.starwars.startWarsProject.model.Rebel;
import com.starwars.startWarsProject.model.TradeList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class RequestTradeInfo {
    public String requestTraderName;
    private TradeList givenItems;
    public String desiredTraderName;
    private TradeList receiveItems;
}
