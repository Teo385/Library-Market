package com.Library_Market.repository;

import com.Library_Market.entity.MisLibros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MisLibrosRepository extends JpaRepository<MisLibros, Integer> {

    List<MisLibros> findByCliente_Idcliente(Integer idCliente);
}
