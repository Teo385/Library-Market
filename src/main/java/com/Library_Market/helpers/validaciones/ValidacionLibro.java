package com.Library_Market.helpers.validaciones;

import com.Library_Market.helpers.mensajes.Mensaje;

public class ValidacionLibro {

    // Validación para el título del libro
    public static void validarTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException(Mensaje.TITULO_LIBRO_INVALIDO.getMensaje());
        }
        if (titulo.length() > 100) {
            throw new IllegalArgumentException(Mensaje.TITULO_LIBRO_INVALIDO.getMensaje());
        }
    }

    // Validación para el precio del libro
    public static void validarPrecio(Double precio) {
        if (precio == null || precio <= 0) {
            throw new IllegalArgumentException(Mensaje.PRECIO_LIBRO_INVALIDO.getMensaje());
        }
    }

    // Validación para el número de páginas del libro
    public static void validarNumeroPaginas(Integer paginas) {
        if (paginas == null || paginas <= 0) {
            throw new IllegalArgumentException(Mensaje.PAGINAS_LIBRO_INVALIDAS.getMensaje());
        }
    }

    // Validación para el ID del autor
    public static void validarIdAutor(Integer idAutor) {
        if (idAutor == null || idAutor <= 0) {
            throw new IllegalArgumentException(Mensaje.ID_AUTOR_INVALIDO.getMensaje());
        }
    }

    // Validación para el ID de la categoría
    public static void validarIdCategoria(Integer idCategoria) {
        if (idCategoria == null || idCategoria <= 0) {
            throw new IllegalArgumentException(Mensaje.ID_CATEGORIA_INVALIDO.getMensaje());
        }
    }

    // Validación para la descripción del libro
    public static void validarDescripcion(String descripcion) {
        if (descripcion != null && descripcion.length() > 500) {
            throw new IllegalArgumentException(Mensaje.DESCRIPCION_LIBRO_INVALIDA.getMensaje());
        }
    }

    // Validación para la calificación del libro
    public static void validarCalificacion(Double calificacion) {
        if (calificacion != null) {
            if (calificacion < 0 || calificacion > 5) {
                throw new IllegalArgumentException(Mensaje.CALIFICACION_LIBRO_INVALIDA.getMensaje());
            }
        }
    }

    // Validación completa para el libro
    public static void validarLibro(String titulo, Double precio, Integer paginas, Integer idAutor, Integer idCategoria, String descripcion, Double calificacion) {
        validarTitulo(titulo);
        validarPrecio(precio);
        validarNumeroPaginas(paginas);
        validarIdAutor(idAutor);
        validarIdCategoria(idCategoria);
        validarDescripcion(descripcion);
        validarCalificacion(calificacion);
    }
}
