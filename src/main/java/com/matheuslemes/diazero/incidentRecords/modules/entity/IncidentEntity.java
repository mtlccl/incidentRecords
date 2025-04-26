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
    private LocalDateTime updatedAt;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime closedAt;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;



    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
