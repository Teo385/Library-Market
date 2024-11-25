package com.Library_Market.controller;

import com.Library_Market.entity.Deseos;
import com.Library_Market.entity.Venta;
import com.Library_Market.service.DeseosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deseos")
public class DeseosController {

    @Autowired
    private DeseosService deseosService;

    // Obtener todos los deseos
    @GetMapping
    public List<Deseos> getAllDeseos() {
        return deseosService.getAllDeseos();
    }

    // Obtener los deseos de un cliente específico
    @GetMapping("/cliente/{idCliente}")
    public List<Deseos> getDeseosByCliente(@PathVariable Integer idCliente) {
        return deseosService.getDeseosByCliente(idCliente);
    }

    // Obtener los deseos de un cliente con un estado específico
    @GetMapping("/cliente/{idCliente}/estado/{estado}")
    public List<Deseos> getDeseosByClienteAndEstado(@PathVariable Integer idCliente, @PathVariable String estado) {
        return deseosService.getDeseosByClienteAndEstado(idCliente, estado);
    }

    // Obtener un deseo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Deseos> getDeseoById(@PathVariable Integer id) {
        return deseosService.getDeseoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo deseo
    @PostMapping
    public Deseos createDeseo(@RequestBody Deseos deseo) {
        return deseosService.saveDeseo(deseo);
    }

    // Actualizar un deseo existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDeseo(@PathVariable Integer id, @RequestBody Deseos deseo) {
        try {
            deseo.setId(id); // Establecer el ID para actualizar
            Deseos ventaActualizada = deseosService.updateDeseo(deseo);
            return ResponseEntity.ok(ventaActualizada);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }}


        // Eliminar un deseo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeseo(@PathVariable Integer id) {
        try {
            deseosService.deleteDeseo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

