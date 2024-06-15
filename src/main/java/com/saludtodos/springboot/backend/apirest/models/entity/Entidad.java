package com.saludtodos.springboot.backend.apirest.models.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Paciente paciente;
    private HistoriaClinica historiaClinica;
    private Medico medico;
    private Consulta consulta;
    private String nombre;
}
