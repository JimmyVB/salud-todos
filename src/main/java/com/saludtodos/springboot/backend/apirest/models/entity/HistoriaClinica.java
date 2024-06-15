package com.saludtodos.springboot.backend.apirest.models.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name = "historia_clinica")
@Data
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    private String fechaIngreso;
    private String fechaAlta;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;
}
