package com.Library_Market.helpers.validaciones;

import com.Library_Market.helpers.mensajes.Mensaje;

public class ValidacionAutor {

    // Validación para el nombre del autor
    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException(Mensaje.NOMBRE_AUTOR_INVALIDO.getMensaje());
        }
        if (nombre.length() > 50) {
            throw new IllegalArgumentException(Mensaje.NOMBRE_AUTOR_INVALIDO.getMensaje());
        }
    }

    // Validación para el apellido del autor
    public static void validarApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException(Mensaje.APELLIDO_AUTOR_INVALIDO.getMensaje());
        }
        if (apellido.length() > 50) {
            throw new IllegalArgumentException(Mensaje.APELLIDO_AUTOR_INVALIDO.getMensaje());
        }
    }

    // Validación para la nacionalidad del autor
    public static void validarNacionalidad(String nacionalidad) {
        if (nacionalidad == null || nacionalidad.isEmpty()) {
            throw new IllegalArgumentException(Mensaje.NACIONALIDAD_AUTOR_INVALIDA.getMensaje());
        }
        if (nacionalidad.length() > 50) {
            throw new IllegalArgumentException(Mensaje.NACIONALIDAD_AUTOR_INVALIDA.getMensaje());
        }
    }

    // Validación completa para un autor
    public static void validarAutor(String nombre, String apellido, String nacionalidad) {
        validarNombre(nombre);
        validarApellido(apellido);
        validarNacionalidad(nacionalidad);
    }
}
