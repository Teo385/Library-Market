package com.Library_Market.helpers.validaciones;

import com.Library_Market.helpers.mensajes.Mensaje;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacionCliente {

    // Validación para el nombre del cliente
    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException(Mensaje.NOMBRE_INVALIDO.getMensaje());
        }
        if (nombre.length() > 50) {
            throw new IllegalArgumentException(Mensaje.NOMBRE_INVALIDO.getMensaje());
        }
        if (!nombre.matches("[A-Za-záéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException(Mensaje.NOMBRE_INVALIDO.getMensaje());
        }
    }

    // Validación para el correo electrónico
    public static void validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException(Mensaje. EMAIL_INVALIDO.getMensaje());
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(Mensaje. EMAIL_INVALIDO.getMensaje());
        }
    }

    // Validación para la dirección del cliente
    public static void validarDireccion(String direccion) {
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException(Mensaje.DIRECCION_INVALIDA.getMensaje());
        }
        if (direccion.length() > 100) {
            throw new IllegalArgumentException(Mensaje.DIRECCION_INVALIDA.getMensaje());
        }
    }

    // Validación para el teléfono del cliente
    public static void validarTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException(Mensaje.TELEFONO_INVALIDO.getMensaje());
        }
        String telefonoRegex = "^\\+?[0-9]{10,15}$"; // Validación para números con o sin código de país
        Pattern pattern = Pattern.compile(telefonoRegex);
        Matcher matcher = pattern.matcher(telefono);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(Mensaje.TELEFONO_INVALIDO.getMensaje());
        }
    }

    // Validación para la contraseña del cliente
    public static void validarContrasena(String contrasena) {
        if (contrasena == null || contrasena.isEmpty()) {
            throw new IllegalArgumentException(Mensaje.CONTRASENA_INVALIDA.getMensaje());
        }
        if (contrasena.length() < 8) {
            throw new IllegalArgumentException(Mensaje.CONTRASENA_INVALIDA.getMensaje());
        }
    }

    // Validación completa para el cliente
    public static void validarCliente(String nombre, String email, String direccion, String telefono, String contrasena) {
        validarNombre(nombre);
        validarEmail(email);
        validarDireccion(direccion);
        validarTelefono(telefono);
        validarContrasena(contrasena);
    }
}
