package com.starwars.startWarsProject.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Report {
    private ReportType reportType;
    private Items item;

    public Report(ReportType reportType){
        this.reportType = reportType;
    }

    public Report(ReportType reportType, Items item){
        this.reportType = reportType;
        this.item = item;
    }
}
