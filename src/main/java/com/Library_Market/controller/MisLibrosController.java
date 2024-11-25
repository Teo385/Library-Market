package com.Library_Market.controller;

import com.Library_Market.entity.Libro;
import com.Library_Market.entity.MisLibros;
import com.Library_Market.service.MisLibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mis-libros")
public class MisLibrosController {

    @Autowired
    private MisLibrosService misLibrosService;

    // Obtener todos los registros
    @GetMapping
    public List<MisLibros> getAllMisLibros() {
        return misLibrosService.getAllMisLibros();
    }

    // Obtener un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<MisLibros> getMisLibroById(@PathVariable Integer id) {
        return misLibrosService.getMisLibroById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo registro
    @PostMapping
    public MisLibros createMisLibro(@RequestBody MisLibros misLibros) {
        return misLibrosService.saveMisLibro(misLibros);
    }

    // Actualizar un registro
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMisLibro(@PathVariable Integer id, @RequestBody MisLibros misLibros) {
        try {
            misLibros.setId(id); // Establece el ID para la actualización
            MisLibros actualizado = misLibrosService.updateMisLibro(misLibros);
            return ResponseEntity.ok(actualizado);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar un registro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMisLibro(@PathVariable Integer id) {
        try {
            misLibrosService.deleteMisLibro(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/mis-libros/{idCliente}")
    public ResponseEntity<List<Libro>> getLibrosEnMisLibros(@PathVariable Integer idCliente) {
        List<Libro> libros = misLibrosService.getLibrosEnMisLibros(idCliente);
        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(libros);
    }
}
