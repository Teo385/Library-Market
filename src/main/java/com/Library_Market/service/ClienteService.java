package com.Library_Market.service;

import com.Library_Market.entity.Cliente;
import com.Library_Market.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por ID
    public Optional<Cliente> getClienteById(Integer id) {
        return clienteRepository.findById(id);
    }

    // Guardar un nuevo cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente
    public Cliente updateCliente(Cliente cliente) throws Exception {
        Cliente clienteExistente = clienteRepository.findById(cliente.getIdcliente())
                .orElseThrow(() -> new RuntimeException("No se encontró el cliente con id: " + cliente.getIdcliente()));

        if (cliente.getNombre() != null) {
            clienteExistente.setNombre(cliente.getNombre());
        }
        if (cliente.getEmail() != null) {
            clienteExistente.setEmail(cliente.getEmail());
        }
        if (cliente.getDireccion() != null) {
            clienteExistente.setDireccion(cliente.getDireccion());
        }
        if (cliente.getTelefono() != null) {
            clienteExistente.setTelefono(cliente.getTelefono());
        }
        if (cliente.getContrasena() != null) {
            clienteExistente.setContrasena(cliente.getContrasena());
        }

        return clienteRepository.save(clienteExistente);
    }

    // Eliminar un cliente
    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
