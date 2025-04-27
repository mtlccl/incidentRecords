package com.matheuslemes.diazero.incidentRecords.modules.usecase;

import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import com.matheuslemes.diazero.incidentRecords.modules.repository.IncidentRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentUseCase {


    @Autowired
    private IncidentRepository incidentRepository;

    public IncidentEntity execute(IncidentEntity incidentEntity) {
        return this.incidentRepository.save(incidentEntity);
    }

    public ArrayList update(IncidentEntity incidentEntity) {

        JSONObject respErrorOrSucess = new JSONObject();
        ArrayList arrays = (ArrayList) this.incidentRepository.findAll();

        try {

            for (Object incidents : arrays) {

                IncidentEntity incidentEntity1 = (IncidentEntity) incidents;
                Integer idRequest = incidentEntity1.getIdIncident();

                if (incidentEntity.getIdIncident().equals(idRequest)) {
                    var result = this.incidentRepository.save(incidentEntity);;
                    arrays = new ArrayList<>();
                    respErrorOrSucess.put("sucesso", "requested id found and update in DB");
                    arrays.add(respErrorOrSucess);
                    arrays.add(result);
                    return ResponseEntity.ok().body(arrays).getBody();
                }
            }
            arrays = new ArrayList<>();
            respErrorOrSucess.put("error", "requested id not found in DB");
            arrays.add(respErrorOrSucess);
            return ResponseEntity.ok().body(arrays).getBody();
        } catch (Exception e) {
            respErrorOrSucess.put("error", "something broke in the search");
            return ResponseEntity.ok().body(arrays).getBody();
        }
    }

    public JSONObject delete(Integer incidentEntity) {
        JSONObject respErrorOrSucess = new JSONObject();

        try {
            ArrayList arrays = (ArrayList) this.incidentRepository.findAll();

            for (Object incidents : arrays) {

                IncidentEntity incidentEntity1 = (IncidentEntity) incidents;
                Integer idRequest = incidentEntity1.getIdIncident();

                if (incidentEntity.equals(idRequest)) {
                    this.incidentRepository.deleteById(idRequest);
                    respErrorOrSucess.put("sucesso", "requested id found and delete in DB");
                    return ResponseEntity.ok().body(respErrorOrSucess).getBody();
                }
            }
            respErrorOrSucess.put("error", "requested id not found in DB");
            return ResponseEntity.ok().body(respErrorOrSucess).getBody();
        } catch (Exception e) {
            respErrorOrSucess.put("error", "something broke in the search");
            return  ResponseEntity.ok().body(respErrorOrSucess).getBody();
        }
    }

    public IncidentEntity getById(Integer incidentEntity) {
        ArrayList arrays = (ArrayList) this.incidentRepository.findAll();

        for (Object incidents : arrays) {

            IncidentEntity incidentEntity1 = (IncidentEntity) incidents;
            Integer idRequest = incidentEntity1.getIdIncident();

            if (incidentEntity.equals(idRequest)) {
                return this.incidentRepository.getReferenceById(incidentEntity);
            }
        }
        return ResponseEntity.ok().body(new IncidentEntity()).getBody();
    }

    public List<IncidentEntity> getByAll() {
        return this.incidentRepository.findAll();
    }

    public List<IncidentEntity> getByOrderTwenty() {
        List<IncidentEntity> columnsFind = this.incidentRepository.findAll();
        if (columnsFind.size() >= 20){
            List<IncidentEntity> orderedByTwenty = this.incidentRepository.getByOrderTwenty();
            return orderedByTwenty;
        }else{
            return columnsFind;
        }
    }

}