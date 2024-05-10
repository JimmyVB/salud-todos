package com.saludtodos.springboot.backend.apirest.controllers;

import com.saludtodos.springboot.backend.apirest.models.entity.Producto;
import com.saludtodos.springboot.backend.apirest.models.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class ProductoRestController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> index(){
        return productoService.findAll();
    }

    @GetMapping("/productos/page/{page}")
    public Page<Producto> index(@PathVariable Integer page){
        return productoService.findAll(PageRequest.of(page, 5));
    }

    @Secured("ROLE_ADMIN")//Si colocar el prefijo
    @PostMapping("/productos")
    public ResponseEntity<?> create(@Valid @RequestBody Producto producto, BindingResult result){

        Map<String, Object> response = new HashMap<>();
        Producto productoNew = null;

        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            productoNew = productoService.save(producto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert a la BD ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El producto ha sido creado con exito!.");
        response.put("producto", productoNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})//Si colocar el prefijo
    @GetMapping("/productos/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();
        Producto producto = null;

        try {
            producto = productoService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la BD ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(producto == null){
            response.put("mensaje", "El producto ID: ".concat(id.toString().concat(" no existe en la BD")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")//Si colocar el prefijo
    @PutMapping("/productos/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Producto producto, BindingResult result, @PathVariable Long id){

        Producto productoActual = productoService.findById(id);
        Producto productoUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(productoActual == null){
            response.put("mensaje", "Error: no se pudo editar, el producto ID: ".concat(id.toString().concat(" no existe en la BD")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());
            productoActual.setStock(producto.getStock());

            productoUpdate = productoService.save(productoActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el cliente en la BD ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El producto ha sido actualizado con exito!.");
        response.put("producto", productoUpdate);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")//Si colocar el prefijo
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();

        try {
            productoService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el producto de la BD ");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El producto ha sido eliminado con exito!.");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
