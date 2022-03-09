package com.starwars.startWarsProject.controller;


import com.starwars.startWarsProject.dto.ResponseReport;
import com.starwars.startWarsProject.service.CreateReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    CreateReportService createReportService = new CreateReportService();

    @GetMapping("/traitors-percentage")
    public ResponseEntity<ResponseReport> traitorsPercentage() {
        return ResponseEntity.ok(new ResponseReport("10%"));
    }

    @GetMapping("/rebels-percentage")
    public  ResponseEntity<ResponseReport> rebelsPercentage() {
        return ResponseEntity.ok(new ResponseReport("90%"));
    }

    @GetMapping("/resources-info")
    public  ResponseEntity<ResponseReport> resourcesInfo() {
        return ResponseEntity.ok(new ResponseReport("2.3 Armas por rebelde"));
    }

    @GetMapping("/loss-points")
    public  ResponseEntity<ResponseReport> lossPonints() {
        return ResponseEntity.ok(new ResponseReport("30 Pontos perdidos"));
    }
}
