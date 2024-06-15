package com.saludtodos.springboot.backend.apirest.models.services;

import com.saludtodos.springboot.backend.apirest.models.dao.IPacienteDao;
import com.saludtodos.springboot.backend.apirest.models.entity.Cliente;
import com.saludtodos.springboot.backend.apirest.models.entity.Paciente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteDao pacienteDao;

    @Override
    public List<Paciente> findAll() {
        return (List<Paciente>) pacienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Paciente> findAll(Pageable pageable) {
        return pacienteDao.findAll(pageable);
    }

    @Override
    public Paciente save(Paciente paciente) {
        return pacienteDao.save(paciente);
    }
}
