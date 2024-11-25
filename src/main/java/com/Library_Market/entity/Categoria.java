package com.Library_Market.entity;


import jakarta.persistence.*;

import java.util.List;

@Table(name="categorias")
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Integer idcategoria;

    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Libro> libros;

    public Integer getIdcategoria() {
        return idcategoria;

    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}