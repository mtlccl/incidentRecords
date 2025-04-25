package com.matheuslemes.diazero.incidentRecords.modules.usecase;

import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import com.matheuslemes.diazero.incidentRecords.modules.repository.IncidentRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentUseCase {
    private IncidentEntity uuid = new IncidentEntity();
    @Autowired
    private IncidentRepository incidentRepository;

    public IncidentEntity execute(IncidentEntity incidentEntity) {

        return this.incidentRepository.save(incidentEntity);
    }

    public IncidentEntity update(IncidentEntity incidentEntity) {
        return this.incidentRepository.save(incidentEntity);
    }

    public void delete(Integer incidentEntity) {
        this.incidentRepository.deleteById(incidentEntity);
    }

    public IncidentEntity getById(Integer incidentEntity) {
        return this.incidentRepository.getReferenceById(incidentEntity);
    }

    public List<IncidentEntity> getByAll() {
        return this.incidentRepository.findAll();
    }

    public List<IncidentEntity> getByOrder20() {
        List<IncidentEntity> a = this.incidentRepository.getByOrder20();
        return a;
    }


}
