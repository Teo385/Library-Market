package com.Library_Market.service;

import com.Library_Market.entity.Categoria;
import com.Library_Market.helpers.validaciones.ValidacionCategoria;
import com.Library_Market.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por ID
    public Optional<Categoria> getCategoriaById(Integer id) {
        return categoriaRepository.findById(id);
    }

    // Guardar una nueva categoría
    public Categoria saveCategoria(Categoria categoria) {
        // Validar los datos de la categoría antes de guardarla
        ValidacionCategoria.validarCategoria(categoria.getNombre());
        return categoriaRepository.save(categoria);
    }

    // Actualizar una categoría
    public Categoria updateCategoria(Categoria categoria) throws Exception {
        // Validar los datos de la categoría antes de actualizarla
        ValidacionCategoria.validarCategoria(categoria.getNombre());

        Categoria categoriaExistente = categoriaRepository.findById(categoria.getIdcategoria())
                .orElseThrow(() -> new RuntimeException("No se encontró la categoría con id: " + categoria.getIdcategoria()));

        if (categoria.getNombre() != null) {
            categoriaExistente.setNombre(categoria.getNombre());
        }

        return categoriaRepository.save(categoriaExistente);
    }

    // Eliminar una categoría
    public void deleteCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
