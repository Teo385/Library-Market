package com.Library_Market.repository;

import com.Library_Market.entity.Deseos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeseosRepository extends JpaRepository<Deseos, Integer> {

    // Método para encontrar deseos por cliente
    List<Deseos> findByCliente_Idcliente(Integer idcliente);

    // Método para encontrar deseos por cliente y estado
    List<Deseos> findByCliente_IdclienteAndEstado(Integer idcliente, String estado);
}
