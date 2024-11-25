package com.Library_Market.service;

import com.Library_Market.entity.Autor;
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
        return autorRepository.save(autor);
    }

    // Actualizar un autor
    public Autor updateAutor(@NotNull Autor autor) throws Throwable {
        Autor autorExistente = (Autor) autorRepository.findById(autor.getIdautor())
                .orElseThrow(() -> new RuntimeException("No se encontro el id: " + autor.getIdautor()));

        if (autor.getNombre() != null) {
            autorExistente.setNombre(autor.getNombre());
        }
        if (autor.getApellido() != null) {
            autorExistente.setApellido(autor.getApellido());
        }
        if (autor.getNacionalidad() != null) {
            autorExistente.setNacionalidad(autor.getNacionalidad());
        }

        return (Autor) saveAutor(autorExistente);
    }

    public void deleteAutor(Integer id) {
        autorRepository.deleteById(id);
    }
}
