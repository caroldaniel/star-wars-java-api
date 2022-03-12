package com.starwars.startWarsProject.service;

import com.starwars.startWarsProject.StartWarsProjectApplication;
import com.starwars.startWarsProject.model.Items;
import com.starwars.startWarsProject.model.Report;

public class ResistenceSystemService {

    public Double traitorPercent() {
        return StartWarsProjectApplication.resistenceSystemDataBase.traitorsPercent();
    }

    public Double trueRebelPercent() {
        return StartWarsProjectApplication.resistenceSystemDataBase.rebelsPercent();
    }

    public Double resourcePerRebelPercent(Items verifyItem) {
        return StartWarsProjectApplication.resistenceSystemDataBase.resourcesPerRebel(verifyItem);
    }

    public Double itemsLossPoints() {
        return StartWarsProjectApplication.resistenceSystemDataBase.itemsLossPoints();
    }

    public String generateReport(Report report) {
        String reportMessage;
        switch (report.getReportType()) {
            case TRAITORS_PERCENTAGE:
                reportMessage = "A porcentagem de traidores é " + traitorPercent().toString();
                break;
            case REBELS_PERCENTAGE:
                reportMessage = "A porcentagem de rebeldes não rebelados é: " + trueRebelPercent().toString();
                break;
            case RESOURCES_PER_REBEL:
                if (report.getItem() == null) {
                    reportMessage = "Item não informado";
                    break;
                }
                reportMessage = "Cada Rebelde possui " +
                        resourcePerRebelPercent(report.getItem()).toString() + " " +
                        report.getItem().toString().toLowerCase() +
                        " items em média.";
                break;
            case ITEMS_LOSS_POINTS:
                reportMessage = "Foram perdidos " + itemsLossPoints().toString() + " pontos em items de traidores.";
                break;
            default:
                throw new RuntimeException("Report Type is not a valid Type");
        }

        return reportMessage;
    }
}
