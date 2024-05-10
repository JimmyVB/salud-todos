package com.saludtodos.springboot.backend.apirest.models.services;

import com.saludtodos.springboot.backend.apirest.models.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();
    public Page<Producto> findAll(Pageable pageable);
    public Producto findById(Long id);
    public Producto save(Producto producto);
    public void delete(Long id);
}

