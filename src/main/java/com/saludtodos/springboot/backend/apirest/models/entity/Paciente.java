package com.saludtodos.springboot.backend.apirest.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private String fechaNacimiento;
    private String genero;
    private String direccion;
    private String telefono;
    private String correo;
    private String grupoSanguineo;
    private String peso;
    private String talla;
    private String alergias;
    private String condicionesGenerales;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoriaClinica> historiasClinicas;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;
}
