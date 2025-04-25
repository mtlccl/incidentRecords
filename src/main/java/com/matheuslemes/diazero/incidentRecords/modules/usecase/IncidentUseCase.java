package com.matheuslemes.diazero.incidentRecords.modules.usecase;

import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import com.matheuslemes.diazero.incidentRecords.modules.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentUseCase {

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

    public List<IncidentEntity> getByOrderTwenty() {
        List<IncidentEntity> orderedByTwenty = this.incidentRepository.getByOrderTwenty();
        return orderedByTwenty;
    }

}
