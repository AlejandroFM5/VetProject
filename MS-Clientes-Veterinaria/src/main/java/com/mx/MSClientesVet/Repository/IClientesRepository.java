package com.mx.MSClientesVet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.MSClientesVet.Entity.Clientes;

@Repository
public interface IClientesRepository extends JpaRepository<Clientes, Long>{

}
