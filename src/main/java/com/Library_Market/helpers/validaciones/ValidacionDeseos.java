package com.Library_Market.helpers.validaciones;

import com.Library_Market.helpers.mensajes.Mensaje;

import java.time.LocalDate;

public class ValidacionDeseos {

    // Validación para el ID del cliente
    public static void validarIdCliente(Integer idCliente) {
        if (idCliente == null || idCliente <= 0) {
            throw new IllegalArgumentException(Mensaje.ID_CLIENTE_INVALIDO.getMensaje());
        }
    }

    // Validación para el ID del producto
    public static void validarIdProducto(Integer idProducto) {
        if (idProducto == null || idProducto <= 0) {
            throw new IllegalArgumentException(Mensaje.ID_PRODUCTO_INVALIDO.getMensaje());
        }
    }

    // Validación para la fecha del deseo
    public static void validarFechaDeseo(LocalDate fechaDeseo) {
        if (fechaDeseo == null) {
            throw new IllegalArgumentException(Mensaje.FECHA_DESEO_INVALIDA.getMensaje());
        }
        if (fechaDeseo.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(Mensaje.FECHA_DESEO_INVALIDA.getMensaje());
        }
    }

    // Validación completa para el deseo
    public static void validarDeseo(Integer idCliente, Integer idProducto, LocalDate fechaDeseo) {
        validarIdCliente(idCliente);
        validarIdProducto(idProducto);
        validarFechaDeseo(fechaDeseo);
    }
}
