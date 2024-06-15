package com.saludtodos.springboot.backend.apirest.models.entity;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name = "consulta")
@Data
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    private Date fechaHoraConsulta;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;
    private String recetaMedica;
}
