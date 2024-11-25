package com.Library_Market.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Integer idlibro;

    private String titulo;

    private Double precio;

    @Column(name = "id_autor")
    private Integer idautor;

    @Column(name = "id_categoria")
    private Integer idcategoria;

    private String descripcion;

    private Double calificacion;

    private Integer paginas;

    private String img;

    @JsonManagedReference("categoria-libro")
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    @ManyToOne
    @JsonManagedReference("autor-libro")
    @JoinColumn(name = "id_autor", insertable = false, updatable = false)
    private Autor autor;

    @JsonBackReference("ventas-libro")
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> ventas;

    @JsonBackReference("misLibros-libro")
    @OneToMany(mappedBy = "libro")
    private List<MisLibros> misLibros;

    @JsonBackReference("deseos-libro")
    @OneToMany(mappedBy = "libro")
    private List<Deseos> deseos;  // Relación con la tabla Deseos

    // Getter y Setter
    public List<Deseos> getDeseos() {
        return deseos;
    }

    public void setDeseos(List<Deseos> deseos) {
        this.deseos = deseos;
    }

    public Integer getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public List<MisLibros> getMisLibros() {
        return misLibros;
    }

    public void setMisLibros(List<MisLibros> misLibros) {
        this.misLibros = misLibros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
