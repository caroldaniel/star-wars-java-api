package com.starwars.startWarsProject.controller;


import com.starwars.startWarsProject.dto.ResponseReport;
import com.starwars.startWarsProject.model.Items;
import com.starwars.startWarsProject.model.Report;
import com.starwars.startWarsProject.model.ReportType;
import com.starwars.startWarsProject.service.ResistenceSystemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    ResistenceSystemService resistenceSystemService = new ResistenceSystemService();

    @GetMapping("/traitors-percentage")
    public ResponseEntity<ResponseReport> traitorsPercentage() {
        Report reportReq = new Report(ReportType.TRAITORS_PERCENTAGE);
        return ResponseEntity.ok(new ResponseReport(resistenceSystemService.generateReport(reportReq)));
    }

    @GetMapping("/rebels-percentage")
    public  ResponseEntity<ResponseReport> rebelsPercentage() {
        Report reportReq = new Report(ReportType.REBELS_PERCENTAGE);
        return ResponseEntity.ok(new ResponseReport(resistenceSystemService.generateReport(reportReq)));
    }

    @GetMapping("/resources-info/{item}")
    public  ResponseEntity<ResponseReport> resourcesInfo(@PathVariable Items item) {
        Report reportReq = new Report(ReportType.RESOURCES_PER_REBEL, item);
        return ResponseEntity.ok(new ResponseReport(resistenceSystemService.generateReport(reportReq)));
    }

    @GetMapping("/items-loss-points")
    public  ResponseEntity<ResponseReport> itemsLossPoints() {
        Report reportReq = new Report(ReportType.ITEMS_LOSS_POINTS);
        return ResponseEntity.ok(new ResponseReport(resistenceSystemService.generateReport(reportReq)));
    }
}
