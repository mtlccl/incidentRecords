package com.matheuslemes.diazero.incidentRecords.modules.usecase;

import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import com.matheuslemes.diazero.incidentRecords.modules.exceptions.UserFoundExcetion;
import com.matheuslemes.diazero.incidentRecords.modules.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentUseCase {

    @Autowired
    private IncidentRepository incidentRepository;

    public IncidentEntity execute(IncidentEntity incidentEntity) {
        this.incidentRepository
                .findByNameOrDescription(incidentEntity.getName(), incidentEntity.getDescription())
                .ifPresent((user) -> {
                    throw new UserFoundExcetion();
                });
        return this.incidentRepository.save(incidentEntity);
    }
}
