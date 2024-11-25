package com.Library_Market.helpers.validaciones;

import com.Library_Market.helpers.mensajes.Mensaje;

public class ValidacionMisLibros {

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

    // Validación para el estado del libro (por ejemplo, "leído", "por leer", etc.)
    public static void validarEstado(String estado) {
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException(Mensaje.ESTADO_LIBRO_INVALIDO.getMensaje());
        }
        // Puede agregarse una validación de los estados permitidos
        if (!(estado.equals("Leído") || estado.equals("Por leer") || estado.equals("Leyendo"))) {
            throw new IllegalArgumentException(Mensaje.ESTADO_LIBRO_INVALIDO.getMensaje());
        }
    }

    // Validación para la relación entre cliente y libro (es decir, si un cliente tiene este libro)
    public static void validarRelacionClienteLibro(Integer idCliente, Integer idLibro, String estado) {
        validarIdCliente(idCliente);
        validarIdLibro(idLibro);
        validarEstado(estado);
    }
}
