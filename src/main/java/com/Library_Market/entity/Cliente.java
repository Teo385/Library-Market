package com.Library_Market.entity;


import jakarta.persistence.*;

import java.util.List;

@Table(name="clientes")
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Integer idcliente;

    private String nombre;

    private String email;

    private String direccion;

    private String telefono;

    private String contrasena;

    @OneToMany(mappedBy = "idventa")
    private List<Venta> ventas;

    @OneToMany(mappedBy = "cliente")
    private List<MisLibros> misLibros;


    @OneToMany(mappedBy = "cliente")
    private List<Deseos> deseos;  // Relación con la tabla Deseos

    // Getter y Setter
    public List<Deseos> getDeseos() {
        return deseos;
    }

    public void setDeseos(List<Deseos> deseos) {
        this.deseos = deseos;
    }


    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public List<MisLibros> getMisLibros() {
        return misLibros;
    }

    public void setMisLibros(List<MisLibros> misLibros) {
        this.misLibros = misLibros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
