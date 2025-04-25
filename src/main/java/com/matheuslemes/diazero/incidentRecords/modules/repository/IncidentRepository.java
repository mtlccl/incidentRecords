package com.matheuslemes.diazero.incidentRecords.modules.repository;

import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IncidentRepository extends JpaRepository<IncidentEntity, Long> {
    Optional<IncidentEntity> findByNameOrDescription(String username, String description);
}
