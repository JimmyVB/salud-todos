package com.saludtodos.springboot.backend.apirest.controllers;

import com.saludtodos.springboot.backend.apirest.models.entity.Cliente;
import com.saludtodos.springboot.backend.apirest.models.entity.Paciente;
import com.saludtodos.springboot.backend.apirest.models.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @GetMapping("/pacientes")
    public List<Paciente> index(){
        return pacienteService.findAll();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/pacientes")
    public ResponseEntity<?> create(@Valid @RequestBody Paciente paciente, BindingResult result){

        Map<String, Object> response = new HashMap<>();
        Paciente pacienteNew = null;

        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            pacienteNew = pacienteService.save(paciente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert a la BD ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El paciente ha sido creado con exito!.");
        response.put("paciente", pacienteNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
