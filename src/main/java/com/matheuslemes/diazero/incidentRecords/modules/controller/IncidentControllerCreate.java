package com.matheuslemes.diazero.incidentRecords.modules.controller;


import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import com.matheuslemes.diazero.incidentRecords.modules.exceptions.ErrorAPI;
import com.matheuslemes.diazero.incidentRecords.modules.exceptions.UserFoundExcetion;
import com.matheuslemes.diazero.incidentRecords.modules.usecase.IncidentUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/incident")
public class IncidentControllerCreate {
    @Autowired
    private IncidentUseCase incidentUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody IncidentEntity incidentEntity) {
        try {

            var result = this.incidentUseCase.execute(incidentEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserFoundExcetion();
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<Object> update(@RequestBody IncidentEntity incidentEntity) {
        try {
            incidentEntity.setUpdatedAt(LocalDateTime.now());
            var result = this.incidentUseCase.update(incidentEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorAPI();
        }
    }

    @DeleteMapping("/delete/{idIncident}")
    public void delete(@PathVariable("idIncident") Integer incidentEntity) {
        try {
            this.incidentUseCase.delete(incidentEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorAPI();
        }
    }

    @GetMapping("/getbyid/{idIncident}")
    public String getById(@PathVariable("idIncident") Integer incidentEntity) {
        try {
            var result = this.incidentUseCase.getById(incidentEntity);
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorAPI();
        }
    }

    @GetMapping("/getbyall")
    public ResponseEntity<Object> getAll() {
        try {
            var result = this.incidentUseCase.getByAll();
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorAPI();
        }
    }

    @GetMapping("/getbyordertable")
    public ResponseEntity<Object> getOrderTable() {
        try {
            var result = this.incidentUseCase.getByOrderTwenty();
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ErrorAPI();
        }
    }
}
