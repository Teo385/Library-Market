package com.Library_Market.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name="autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Autor")
    private Integer idautor;

    private String nombre;

    private String apellido;

    private String nacionalidad;

    @JsonBackReference("categoria-libros")
    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }


}
