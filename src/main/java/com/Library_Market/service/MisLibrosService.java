package com.Library_Market.service;

import com.Library_Market.entity.Libro;
import com.Library_Market.entity.MisLibros;
import com.Library_Market.helpers.validaciones.ValidacionMisLibros;
import com.Library_Market.repository.MisLibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MisLibrosService {

    @Autowired
    private MisLibrosRepository misLibrosRepository;

    // Obtener todos los registros
    public List<MisLibros> getAllMisLibros() {
        return misLibrosRepository.findAll();
    }

    // Obtener un registro por ID
    public Optional<MisLibros> getMisLibroById(Integer id) {
        return misLibrosRepository.findById(id);
    }

    // Guardar un nuevo registro
    public MisLibros saveMisLibro(MisLibros misLibros) {
        // Validar la relación entre el cliente y el libro antes de guardar
        ValidacionMisLibros.validarRelacionClienteLibro(
                misLibros.getCliente().getIdcliente(),
                misLibros.getLibro().getIdlibro(),
                misLibros.getEstado()
        );
        return misLibrosRepository.save(misLibros);
    }

    // Actualizar un registro
    public MisLibros updateMisLibro(MisLibros misLibros) throws Exception {
        // Validar la relación entre el cliente y el libro antes de actualizar
        ValidacionMisLibros.validarRelacionClienteLibro(
                misLibros.getCliente().getIdcliente(),
                misLibros.getLibro().getIdlibro(),
                misLibros.getEstado()
        );

        MisLibros existente = misLibrosRepository.findById(misLibros.getId())
                .orElseThrow(() -> new RuntimeException("No se encontró el registro con id: " + misLibros.getId()));

        if (misLibros.getTexto() != null) {
            existente.setTexto(misLibros.getTexto());
        }
        if (misLibros.getFechaCompra() != null) {
            existente.setFechaCompra(misLibros.getFechaCompra());
        }
        if (misLibros.getEstado() != null) {
            existente.setEstado(misLibros.getEstado());
        }

        return misLibrosRepository.save(existente);
    }

    // Eliminar un registro
    public void deleteMisLibro(Integer id) {
        misLibrosRepository.deleteById(id);
    }

    // Obtener los libros de un cliente específico desde "MisLibros"
    public List<Libro> getLibrosEnMisLibros(Integer idCliente) {
        return misLibrosRepository.findByCliente_Idcliente(idCliente).stream()
                .map(MisLibros::getLibro)
                .collect(Collectors.toList());
    }
}
