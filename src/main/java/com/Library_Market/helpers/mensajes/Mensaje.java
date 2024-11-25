package com.Library_Market.helpers.mensajes;

public enum Mensaje {

    ID_CLIENTE_INVALIDO("El ID del cliente debe ser un valor válido y mayor que 0."),
    ID_PRODUCTO_INVALIDO("El ID del producto debe ser un valor válido y mayor que 0."),
    FECHA_DESEO_INVALIDA("La fecha del deseo no puede ser nula ni estar en el futuro."),
    ID_LIBRO_INVALIDO("El ID del libro debe ser un valor válido y mayor que 0."),
    TITULO_LIBRO_INVALIDO("El título del libro no puede ser vacío ni tener más de 100 caracteres."),
    DESCRIPCION_LIBRO_INVALIDA("La descripción del libro no puede tener más de 500 caracteres."),
    PRECIO_LIBRO_INVALIDO("El precio del libro debe ser un valor positivo mayor que 0."),
    CALIFICACION_LIBRO_INVALIDA("La calificación del libro debe estar entre 0 y 5."),
    PAGINAS_LIBRO_INVALIDAS("El número de páginas del libro debe ser mayor que 0."),
    ID_AUTOR_INVALIDO("El ID del autor debe ser un valor válido y mayor que 0."),
    ID_CATEGORIA_INVALIDO("El ID de la categoría debe ser un valor válido y mayor que 0."),
    ESTADO_LIBRO_INVALIDO("El estado del libro debe ser 'Leído', 'Por leer' o 'Leyendo'."),
    CANTIDAD_INVALIDA("La cantidad de libros en la venta debe ser mayor que 0."),
    FECHA_VENTA_INVALIDA("La fecha de la venta no puede ser una fecha futura."),
    NOMBRE_AUTOR_INVALIDO("El nombre del autor no puede tener más de 50 caracteres."),
    APELLIDO_AUTOR_INVALIDO("El apellido del autor no puede tener más de 50 caracteres."),
    NACIONALIDAD_AUTOR_INVALIDA("La nacionalidad del autor no puede tener más de 50 caracteres."),
    NOMBRE_CATEGORIA_INVALIDO("El nombre de la categoría no puede tener más de 50 caracteres."),
    NOMBRE_INVALIDO("El nombre del cliente no puede tener más de 50 caracteres."),
    EMAIL_INVALIDO("El email del cliente no es válido."),
    TELEFONO_INVALIDO("El teléfono del cliente no puede tener más de 15 caracteres."),
    DIRECCION_INVALIDA("La dirección del cliente no puede tener más de 100 caracteres."),
    CONTRASENA_INVALIDA("La contraseña del cliente debe tener al menos 8 caracteres.");

    private String mensaje;

    Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
