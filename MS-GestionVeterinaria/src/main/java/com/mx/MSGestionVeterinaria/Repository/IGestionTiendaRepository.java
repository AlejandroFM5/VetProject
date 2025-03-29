package com.mx.MSGestionVeterinaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.MSGestionVeterinaria.Entity.GestionVeterinaria;

@Repository
public interface IGestionTiendaRepository extends JpaRepository<GestionVeterinaria, Long>{

}
