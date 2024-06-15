package com.saludtodos.springboot.backend.apirest.models.dao;

import com.saludtodos.springboot.backend.apirest.models.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteDao extends JpaRepository<Paciente, Long> {
}
