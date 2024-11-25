package com.Library_Market.service;

import com.Library_Market.entity.Venta;
import com.Library_Market.helpers.validaciones.ValidacionVenta;
import com.Library_Market.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // Obtener todas las ventas
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    // Obtener una venta por ID
    public Optional<Venta> getVentaById(Integer id) {
        return ventaRepository.findById(id);
    }

    // Guardar una nueva venta
    public Venta saveVenta(Venta venta) {
        // Realizar las validaciones antes de guardar la venta
        ValidacionVenta.validarVenta(
                venta.getCliente().getIdcliente(),
                venta.getLibro().getIdlibro(),
                venta.getCantidad(),
                venta.getFechaventa()
        );
        return ventaRepository.save(venta);
    }

    // Actualizar una venta
    public Venta updateVenta(Venta venta) throws Exception {
        // Realizar las validaciones antes de actualizar la venta
        ValidacionVenta.validarVenta(
                venta.getCliente().getIdcliente(),
                venta.getLibro().getIdlibro(),
                venta.getCantidad(),
                venta.getFechaventa()
        );

        Venta ventaExistente = ventaRepository.findById(venta.getIdventa())
                .orElseThrow(() -> new RuntimeException("No se encontró la venta con id: " + venta.getIdventa()));

        if (venta.getCantidad() != null) {
            ventaExistente.setCantidad(venta.getCantidad());
        }
        if (venta.getFechaventa() != null) {
            ventaExistente.setFechaventa(venta.getFechaventa());
        }

        return ventaRepository.save(ventaExistente);
    }

    // Eliminar una venta
    public void deleteVenta(Integer id) {
        ventaRepository.deleteById(id);
    }
}
