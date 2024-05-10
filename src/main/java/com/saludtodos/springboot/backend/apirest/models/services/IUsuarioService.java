package com.saludtodos.springboot.backend.apirest.models.services;

import com.saludtodos.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {

    public Usuario findByUsername(String username);

}
