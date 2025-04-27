package com.matheuslemes.diazero.incidentRecords.modules.controller;


import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import com.matheuslemes.diazero.incidentRecords.modules.exceptions.ErrorAPI;
import com.matheuslemes.diazero.incidentRecords.modules.usecase.IncidentUseCase;
import com.matheuslemes.diazero.incidentRecords.modules.utilsIncident.utilsRespMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/incident")

@Tag(name = "IncidentAPIS", description = "API information")

public class IncidentControllerCreate {
    @Autowired
    private IncidentUseCase incidentUseCase;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${security.token.secret}")
    private String secretKey;


    @PostMapping("/create")
    @Operation(summary = "Create Columns", description = "This api generates new columns")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = IncidentEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "incident already registered")
    })


    public ResponseEntity<List> createNewColumns(@Valid @RequestBody IncidentEntity incidentEntity) {
        try {

            var result = this.incidentUseCase.execute(incidentEntity);
            String token = utilsRespMessage.genToken(incidentEntity, passwordEncoder, secretKey);

            JSONArray respArray = new JSONArray();
            List<JSONArray> respListReturn = new ArrayList<>();

            respArray.put(result);
            respArray.put("AuthorizationToken: " + token);
            respListReturn.add(respArray);

            return ResponseEntity.ok(respListReturn.get(0).toList());
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
    @Operation(summary = "Update Collum", description = "This API updates columns of a table")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = IncidentEntity.class))
            }),
            @ApiResponse(responseCode = "400", description = "user not found")
    })
    public ResponseEntity<List> updateColumns(@RequestBody IncidentEntity incidentEntity) throws EntityNotFoundException {
        try {
            incidentEntity.setUpdatedAt(LocalDateTime.now());
            var result = this.incidentUseCase.update(incidentEntity);
            String token = utilsRespMessage.genToken(incidentEntity, passwordEncoder, secretKey);

            JSONArray respArray = new JSONArray();
            List<JSONArray> respListReturn = new ArrayList<>();

            respArray.put(result);
            respArray.put("AuthorizationTokenUpdate: " + token);
            respListReturn.add(respArray);

            return ResponseEntity.ok(respListReturn.get(0).toList());
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
    @PreAuthorize("hasRole('INCIDENT')")
    @Operation(summary = "Delete Column", description = "this api deletes a column")
    @SecurityRequirement(name = "jwt_auth")
    public void deleteColumns(@PathVariable("idIncident") Integer incidentEntity) throws EntityNotFoundException {
        try {
            this.incidentUseCase.delete(incidentEntity);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new ErrorAPI();
        }
    }


    @GetMapping("/getbyid/{idIncident}")
    @PreAuthorize("hasRole('INCIDENT')")
    @Operation(summary = "Column by ID", description = "this api returns a specific Column using the id")
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> getColumnById(@PathVariable("idIncident") Integer incidentEntity) {
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
    @PreAuthorize("hasRole('INCIDENT')")
    @Operation(summary = "All Columns", description = "This API returns all possible Columns from the database")
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> getAllColumns() {
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
    @PreAuthorize("hasRole('INCIDENT')")
    @Operation(summary = "Ordered Column", description = "This API returns the twenty Columns in descending order")
    @SecurityRequirement(name = "jwt_auth")
    public ResponseEntity<Object> getOrderColumns() {
        try {
            var result = this.incidentUseCase.getByOrderTwenty();
            if (result.size() >= 20) {
                return ResponseEntity.ok().body(result);

            } else {
                JSONObject respMSG = new JSONObject();
                JSONArray respArray = new JSONArray();
                List<JSONArray> respListReturn = new ArrayList<>();
                respMSG.put("error", "you don't have enough columns to return, number of columns available: " + result.size());
                respArray.put(respMSG);
                respListReturn.add(respArray);

                return ResponseEntity.ok(respListReturn.get(0).toList());
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
}
