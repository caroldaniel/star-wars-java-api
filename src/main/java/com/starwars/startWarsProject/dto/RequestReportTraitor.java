package com.starwars.startWarsProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class RequestReportTraitor {
    private String traitorName;
    private String reporter;
}
