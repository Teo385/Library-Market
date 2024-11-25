package com.Library_Market.service;

import com.Library_Market.entity.Deseos;
import com.Library_Market.repository.DeseosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeseosService {

    @Autowired
    private DeseosRepository deseosRepository;

    // Obtener todos los deseos
    public List<Deseos> getAllDeseos() {
        return deseosRepository.findAll();
    }

    // Obtener los deseos de un cliente específico
    public List<Deseos> getDeseosByCliente(Integer idcliente) {
        return deseosRepository.findByCliente_Idcliente(idcliente);
    }

    // Obtener los deseos de un cliente con un estado específico
    public List<Deseos> getDeseosByClienteAndEstado(Integer idcliente, String estado) {
        return deseosRepository.findByCliente_IdclienteAndEstado(idcliente, estado);
    }

    // Obtener un deseo específico por su ID
    public Optional<Deseos> getDeseoById(Integer id) {
        return deseosRepository.findById(id);
    }

    // Guardar un nuevo deseo
    public Deseos saveDeseo(Deseos deseo) {
        // Validar los datos del deseo antes de guardarlo
        // Asegúrate de que 'deseo.getLibro()' no sea null
        if (deseo.getLibro() == null || deseo.getLibro() == null) {
            throw new IllegalArgumentException("El libro asociado al deseo no es válido.");
        }

        return deseosRepository.save(deseo);
    }

    // Actualizar un deseo existente
    public Deseos updateDeseo(Deseos deseo) throws Throwable {
        // Validar los datos del deseo antes de actualizarlo
        // Asegúrate de que 'deseo.getLibro()' no sea null
        if (deseo.getLibro() == null || deseo.getLibro().getIdlibro() == null) {
            throw new IllegalArgumentException("El libro asociado al deseo no es válido.");
        }

        Deseos deseoExistente = deseosRepository.findById(deseo.getId())
                .orElseThrow(() -> new RuntimeException("No se encontró el deseo con ID: " + deseo.getId()));

        if (deseo.getEstado() != null) {
            deseoExistente.setEstado(deseo.getEstado());
        }

        if (deseo.getNota() != null) {
            deseoExistente.setNota(deseo.getNota());
        }

        return deseosRepository.save(deseoExistente);
    }

    // Eliminar un deseo
    public void deleteDeseo(Integer id) {
        deseosRepository.deleteById(id);
    }
}
