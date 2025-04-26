package com.matheuslemes.diazero.incidentRecords.modules.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity(name = "incident")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncidentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idIncident;

    @NotBlank(message = "Esse campo é obrigatório")
    @Column(nullable = false, unique = true)
    @Schema(example = "Name incident")
    private String name;

    @NotBlank(message = "Esse campo é obrigatório")
    @Column(nullable = false, unique = true)
    @Schema(example = "Description")
    private String description;

    @CreationTimestamp
    private LocalDateTime updatedAt;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime closedAt;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public Integer getIdIncident() {
        return idIncident;
    }

    public String getDescription() {
        return description;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
