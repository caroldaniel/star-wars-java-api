package com.starwars.startWarsProject.service;

import com.starwars.startWarsProject.StartWarsProjectApplication;
import com.starwars.startWarsProject.dto.RequestTradeInfo;
import com.starwars.startWarsProject.model.Rebel;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TradeService {

    public void tradeItem(RequestTradeInfo requestTradeInfo) throws IllegalAccessException {
        Rebel requestRebel  = StartWarsProjectApplication.resistenceSystemDataBase.getRebel(requestTradeInfo.requestTraderName);
        Rebel desiredRebel  = StartWarsProjectApplication.resistenceSystemDataBase.getRebel(requestTradeInfo.desiredTraderName);
        if (requestRebel.getIsTraitor() || desiredRebel.getIsTraitor()) {
            throw new IllegalAccessException("ESTAMOS ENTRE TRAIDORES!!!!");
        } else {
          if (Objects.equals(requestTradeInfo.getGivenItems().getValue(), requestTradeInfo.getReceiveItems().getValue())) {
              requestRebel.updateInventory(requestTradeInfo.getReceiveItems(), requestTradeInfo.getGivenItems());
              desiredRebel.updateInventory(requestTradeInfo.getGivenItems(), requestTradeInfo.getReceiveItems());
          } else {
              throw new IllegalArgumentException("Troca não permitida");
          }
        }
    }
}
