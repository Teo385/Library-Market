package com.Library_Market.repository;

import com.Library_Market.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findByCategoria_Idcategoria(Integer idCategoria);
}
