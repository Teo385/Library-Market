package com.Library_Market.service;

import com.Library_Market.entity.Libro;
import com.Library_Market.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Obtener todos los libros
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    // Obtener un libro por ID
    public Optional<Libro> getLibroById(Integer id) {
        return libroRepository.findById(id);
    }

    // Guardar un nuevo libro
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Actualizar un libro
    public Libro updateLibro(Libro libro) throws Exception {
        Libro libroExistente = libroRepository.findById(libro.getIdlibro())
                .orElseThrow(() -> new RuntimeException("No se encontró el libro con id: " + libro.getIdlibro()));

        if (libro.getTitulo() != null) {
            libroExistente.setTitulo(libro.getTitulo());
        }
        if (libro.getPrecio() != null) {
            libroExistente.setPrecio(libro.getPrecio());
        }
        if (libro.getDescripcion() != null) {
            libroExistente.setDescripcion(libro.getDescripcion());
        }
        if (libro.getCalificacion() != null) {
            libroExistente.setCalificacion(libro.getCalificacion());
        }
        if (libro.getPaginas() != null) {
            libroExistente.setPaginas(libro.getPaginas());
        }
        if (libro.getImg() != null) {
            libroExistente.setImg(libro.getImg());
        }

        return libroRepository.save(libroExistente);
    }

    // Eliminar un libro
    public void deleteLibro(Integer id) {
        libroRepository.deleteById(id);
    }

    public List<Libro> getLibrosByCategoria(Integer idCategoria) {
        return libroRepository.findByCategoria_Idcategoria(idCategoria);
    }
}
