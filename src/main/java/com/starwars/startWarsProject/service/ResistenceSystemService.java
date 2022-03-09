package com.starwars.startWarsProject.service;

import com.starwars.startWarsProject.StartWarsProjectApplication;
import com.starwars.startWarsProject.model.Items;

public class ResistenceSystemService {

    public Double traitorPercent() {
        return StartWarsProjectApplication.resistenceSystem.traitorsPercent();
    }

    public Double trueRebelPercent() {
        return StartWarsProjectApplication.resistenceSystem.rebelsPercent();
    }

    public Double resourcePerRebelPercent(Items verifyItem) {
        return StartWarsProjectApplication.resistenceSystem.resourcePerRebelPercent(verifyItem);
    }
}
