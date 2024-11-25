package com.Library_Market.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "deseos")
@Entity
public class Deseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;  // Clave primaria

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;  // Relación con Cliente

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;  // Relación con Libro

    @Column(name = "estado")
    private String estado;  // Estado del deseo (ejemplo: "pendiente", "comprado", etc.)

    @Column(name = "fecha_agregado")
    private LocalDate fechaAgregado;  // Fecha en que el libro fue agregado a la lista de deseos

    @Column(name = "nota")
    private String nota;  // Nota personal del cliente sobre el libro


    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(LocalDate fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
