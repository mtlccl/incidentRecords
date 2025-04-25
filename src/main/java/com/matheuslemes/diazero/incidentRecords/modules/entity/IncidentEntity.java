package com.matheuslemes.diazero.incidentRecords.modules.entity;

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
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idIncident;

    @NotBlank(message = "Esse campo é obrigatório")
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Esse campo é obrigatório")
    @Column(nullable = false, unique = true)
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;

    @CreationTimestamp
    private LocalDateTime closedAt;

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }
}
