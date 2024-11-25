package com.Library_Market.controller;

import com.Library_Market.entity.Libro;
import com.Library_Market.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Obtener todos los libros
    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.getAllLibros();
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Integer id) {
        return libroService.getLibroById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo libro
    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }

    // Actualizar un libro
    @PutMapping("/{id}")
    public ResponseEntity<?> updateLibro(@PathVariable Integer id, @RequestBody Libro libro) {
        try {
            libro.setIdlibro(id);
            Libro libroActualizado = libroService.updateLibro(libro);
            return ResponseEntity.ok(libroActualizado);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Eliminar un libro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Integer id) {
        try {
            libroService.deleteLibro(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<Libro>> getLibrosByCategoria(@PathVariable Integer idCategoria) {
        List<Libro> libros = libroService.getLibrosByCategoria(idCategoria);
        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(libros);
    }

}
