package com.matheuslemes.diazero.incidentRecords.modules.controller;


import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import com.matheuslemes.diazero.incidentRecords.modules.usecase.IncidentUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.matheuslemes.diazero.incidentRecords.utils.*;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/incident")
public class IncidentControllerCreate {
    @Autowired
    private IncidentUseCase incidentUseCase;
    int i = 0;

    public void execute(){

    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody IncidentEntity incidentEntity) {
        try {
            var result = this.incidentUseCase.execute(incidentEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@Valid @RequestBody IncidentEntity incidentEntity) {
        try {
            var result = this.incidentUseCase.execute(incidentEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@Valid @RequestBody IncidentEntity incidentEntity) {
        try {
            var result = this.incidentUseCase.execute(incidentEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
