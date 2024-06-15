package com.saludtodos.springboot.backend.apirest.models.services;

import com.saludtodos.springboot.backend.apirest.models.entity.Cliente;
import com.saludtodos.springboot.backend.apirest.models.entity.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPacienteService {

    public List<Paciente> findAll();
    public Page<Paciente> findAll(Pageable pageable);
    public Paciente save(Paciente paciente);
}
