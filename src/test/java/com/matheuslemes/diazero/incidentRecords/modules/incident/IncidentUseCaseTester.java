package com.matheuslemes.diazero.incidentRecords.modules.incident;

import com.matheuslemes.diazero.incidentRecords.modules.repository.IncidentRepository;
import com.matheuslemes.diazero.incidentRecords.modules.usecase.IncidentUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IncidentUseCaseTester {

    @InjectMocks
    private IncidentUseCase incidentUseCase;

    @Mock
    private IncidentRepository incidentRepository;

    @Test
    @DisplayName("incidentUpdate")
    public void should_no_be_update_to_incident_with_id_incident_not_found(){
        try {
            incidentUseCase.execute(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
