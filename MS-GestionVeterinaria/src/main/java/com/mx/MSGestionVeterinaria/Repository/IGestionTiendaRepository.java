package com.mx.MSGestionVeterinaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.MSGestionVeterinaria.Entity.GestionVeterinaria;

@Repository
public interface IGestionTiendaRepository extends JpaRepository<GestionVeterinaria, Long>{
	@Query(nativeQuery = true,
			value = "SELECT ID_VETERINARIA, NOMBRE, DIRECCION, TELEFONO "+
					"FROM VETERINARIA "+
					"WHERE UPPER(NOMBRE) = UPPER(:nombre)")
	public GestionVeterinaria withOutDuplicates(String nombre);
}
