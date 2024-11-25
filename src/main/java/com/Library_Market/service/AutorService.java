package com.Library_Market.service;

import com.Library_Market.entity.Autor;
import com.Library_Market.helpers.validaciones.ValidacionAutor;
import com.Library_Market.repository.AutorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired(required = true)
    private AutorRepository autorRepository;

    // Obtener todos los autores
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    // Obtener un autor por su ID
    public Optional<Autor> getAutorById(Integer id) {
        return autorRepository.findById(id);
    }

    // Guardar un nuevo autor
    public Object saveAutor(Autor autor) {
        // Validar los datos del autor antes de guardarlo
        ValidacionAutor.validarAutor(autor.getNombre(), autor.getApellido(), autor.getNacionalidad());
        return autorRepository.save(autor);
    }

    // Actualizar un autor
    public Autor updateAutor(@NotNull Autor autor) throws Throwable {
        // Validar los datos del autor antes de actualizarlo
        ValidacionAutor.validarAutor(autor.getNombre(), autor.getApellido(), autor.getNacionalidad());

        Autor autorExistente = autorRepository.findById(autor.getIdautor())
                .orElseThrow(() -> new RuntimeException("No se encontró el id: " + autor.getIdautor()));

        if (autor.getNombre() != null) {
            autorExistente.setNombre(autor.getNombre());
        }
        if (autor.getApellido() != null) {
            autorExistente.setApellido(autor.getApellido());
        }
        if (autor.getNacionalidad() != null) {
            autorExistente.setNacionalidad(autor.getNacionalidad());
        }

        return autorRepository.save(autorExistente);
    }

    // Eliminar un autor
    public void deleteAutor(Integer id) {
        autorRepository.deleteById(id);
    }
}
