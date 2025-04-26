package com.matheuslemes.diazero.incidentRecords.modules.controller;


import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import com.matheuslemes.diazero.incidentRecords.modules.exceptions.ErrorAPI;
import com.matheuslemes.diazero.incidentRecords.modules.usecase.IncidentUseCase;
import com.matheuslemes.diazero.incidentRecords.modules.utilsIncident.utilsRespMessage;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@RestController
@RequestMapping("/incident")

@Tag(name = "Candidato", description = "informacoes do candidato")

public class IncidentControllerCreate {
    @Autowired
    private IncidentUseCase incidentUseCase;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${security.token.secret}")
    private String secretKey;


    @PostMapping("/create")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = IncidentEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "incident already registered")
    })
    public ResponseEntity<List> create(@Valid @RequestBody IncidentEntity incidentEntity) {
        try {

            var result = this.incidentUseCase.execute(incidentEntity);
            String token = utilsRespMessage.genToken(incidentEntity, passwordEncoder, secretKey);

            JSONArray resp2 = new JSONArray();
            resp2.put(result);
            resp2.put("AuthorizationToken: " + token);
            List<JSONArray> resp = new ArrayList<>();
            resp.add(resp2);

            return ResponseEntity.ok(resp.get(0).toList());
        } catch (Exception e) {
            e.getMessage();
            if (!e.getMessage().isEmpty()) {
                return ResponseEntity.ok(utilsRespMessage.formatMessages(e.getMessage()));
            } else {
                return ResponseEntity.ok(utilsRespMessage.formatMessages(e.getMessage()));
            }
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<List> update(@RequestBody IncidentEntity incidentEntity) throws EntityNotFoundException {
        try {
            incidentEntity.setUpdatedAt(LocalDateTime.now());
            var result = this.incidentUseCase.update(incidentEntity);
            String token = utilsRespMessage.genToken(incidentEntity, passwordEncoder, secretKey);

            JSONArray resp2 = new JSONArray();
            resp2.put(result);
            resp2.put("AuthorizationTokenUpdate: " + token);
            List<JSONArray> resp = new ArrayList<>();
            resp.add(resp2);

            return ResponseEntity.ok(resp.get(0).toList());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            if (!e.getMessage().isEmpty()) {

                return ResponseEntity.ok(utilsRespMessage.formatMessages(e.getMessage()));

            } else {
                throw new ErrorAPI();
            }
        }
    }

    @DeleteMapping("/delete/{idIncident}")
    public void delete(@PathVariable("idIncident") Integer incidentEntity) throws EntityNotFoundException {
        try {
            this.incidentUseCase.delete(incidentEntity);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new ErrorAPI();
        }
    }

    @GetMapping("/getbyid/{idIncident}")
    public ResponseEntity<Object> getById(@PathVariable("idIncident") Integer incidentEntity) {
        try {
            var result = this.incidentUseCase.getById(incidentEntity);
            if (result.getDescription() != null) {
                return ResponseEntity.ok().body(result);
            } else {
                return ResponseEntity.ok(utilsRespMessage.formatMessages("id not found"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (!e.getMessage().isEmpty()) {

                return ResponseEntity.ok(utilsRespMessage.formatMessages(e.getMessage()));

            } else {
                return ResponseEntity.ok().body(e.getMessage());
            }
        }
    }

    @GetMapping("/getbyall")
    public ResponseEntity<Object> getAll() {
        try {
            var result = this.incidentUseCase.getByAll();
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            e.printStackTrace();
            if (!e.getMessage().isEmpty()) {

                return ResponseEntity.ok(utilsRespMessage.formatMessages(e.getMessage()));

            } else {
                return ResponseEntity.ok().body(e.getMessage());
            }
        }
    }

    @GetMapping("/getbyordertable")
    public ResponseEntity<Object> getOrderTable() {
        try {
            var result = this.incidentUseCase.getByOrderTwenty();
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            e.printStackTrace();
            if (!e.getMessage().isEmpty()) {

                return ResponseEntity.ok(utilsRespMessage.formatMessages(e.getMessage()));

            } else {
                return ResponseEntity.ok().body(e.getMessage());
            }
        }
    }
}
