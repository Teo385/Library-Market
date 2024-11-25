package com.Library_Market.helpers.validaciones;

import com.Library_Market.helpers.mensajes.Mensaje;

public class ValidacionVenta {

    // Validación para el ID del cliente
    public static void validarIdCliente(Integer idCliente) {
        if (idCliente == null || idCliente <= 0) {
            throw new IllegalArgumentException(Mensaje.ID_CLIENTE_INVALIDO.getMensaje());
        }
    }

    // Validación para el ID del libro
    public static void validarIdLibro(Integer idLibro) {
        if (idLibro == null || idLibro <= 0) {
            throw new IllegalArgumentException(Mensaje.ID_LIBRO_INVALIDO.getMensaje());
        }
    }

    // Validación para la cantidad de libros
    public static void validarCantidad(Integer cantidad) {
        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException(Mensaje.CANTIDAD_INVALIDA.getMensaje());
        }
    }

    // Validación para la fecha de venta (no debe ser en el futuro)
    public static void validarFechaVenta(java.time.LocalDate fechaVenta) {
        if (fechaVenta == null) {
            throw new IllegalArgumentException(Mensaje.FECHA_VENTA_INVALIDA.getMensaje());
        }
        if (fechaVenta.isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException(Mensaje.FECHA_VENTA_INVALIDA.getMensaje());
        }
    }

    // Validación para todos los campos de la venta
    public static void validarVenta(Integer idCliente, Integer idLibro, Integer cantidad, java.time.LocalDate fechaVenta) {
        validarIdCliente(idCliente);
        validarIdLibro(idLibro);
        validarCantidad(cantidad);
        validarFechaVenta(fechaVenta);
    }
}
