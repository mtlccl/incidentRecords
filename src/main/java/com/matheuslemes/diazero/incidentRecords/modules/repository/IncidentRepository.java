package com.matheuslemes.diazero.incidentRecords.modules.repository;

import com.matheuslemes.diazero.incidentRecords.modules.entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncidentRepository extends JpaRepository<IncidentEntity, Integer> {


    @Query(value = "SELECT * FROM incident ORDER BY id_incident DESC LIMIT 20", nativeQuery = true)
    List<IncidentEntity> getByOrder20();
}
