package com.Library_Market.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mis_libros")
public class MisLibros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro libro;

    @Column(name = "texto")
    private String texto;

    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;

    @Column(name = "estado")
    private String estado; // Ejemplo de un campo adicional: "Leído", "No leído", "Leyendo"


    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;  // Relación con Cliente

    // Getters y Setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
