package com.starwars.startWarsProject.controller;


import com.starwars.startWarsProject.dto.ResponseLossPoints;
import com.starwars.startWarsProject.dto.ResponseRebelsPercentage;
import com.starwars.startWarsProject.dto.ResponseResourcesInfo;
import com.starwars.startWarsProject.dto.ResponseTraitorsPercentage;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @GetMapping("/traitors-percentage")
    public ResponseEntity<ResponseTraitorsPercentage> traitorsPercentage() {
        return ResponseEntity.ok(new ResponseTraitorsPercentage("10%"));
    }

    @GetMapping("/rebels-percentage")
    public  ResponseEntity<ResponseRebelsPercentage> rebelsPercentage() {
        return ResponseEntity.ok(new ResponseRebelsPercentage("90%"));
    }

    @GetMapping("/resources-info")
    public  ResponseEntity<ResponseResourcesInfo> resourcesInfo() {
        return ResponseEntity.ok(new ResponseResourcesInfo("2.3 Armas por rebelde"));
    }

    @GetMapping("/loss-points")
    public  ResponseEntity<ResponseLossPoints> lossPonints() {
        return ResponseEntity.ok(new ResponseLossPoints("30 Pontos perdidos"));
    }


}
