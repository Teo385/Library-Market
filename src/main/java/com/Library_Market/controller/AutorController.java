package com.Library_Market.controller;

import com.Library_Market.entity.Autor;
import com.Library_Market.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Obtener todos los autores
    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.getAllAutores();
    }

    // Obtener un autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Integer id) {
        return autorService.getAutorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo autor
    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return (Autor) autorService.saveAutor(autor);
    }

    // Actualizar un autor
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        try {
            Autor autorActualizado = autorService.updateAutor(autor);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(autorActualizado);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    // Eliminar un autor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Integer id) {
        try {
            autorService.deleteAutor(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
