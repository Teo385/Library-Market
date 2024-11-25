package com.Library_Market.helpers.validaciones;

import com.Library_Market.helpers.mensajes.Mensaje;

public class ValidacionCategoria {

    // Validación para el nombre de la categoría
    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException(Mensaje.NOMBRE_CATEGORIA_INVALIDO.getMensaje());
        }
        if (nombre.length() > 50) {
            throw new IllegalArgumentException(Mensaje.NOMBRE_CATEGORIA_INVALIDO.getMensaje());
        }
        if (!nombre.matches("[A-Za-záéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException(Mensaje.NOMBRE_CATEGORIA_INVALIDO.getMensaje());
        }
    }

    // Validación completa para la categoría
    public static void validarCategoria(String nombre) {
        validarNombre(nombre);
    }
}
