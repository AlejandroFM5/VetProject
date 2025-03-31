package com.mx.MSResponsables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.MSResponsables.Entity.Responsables;

@Repository
public interface IResponsablesRepository extends JpaRepository<Responsables, Long>{
	@Query(nativeQuery = true,
			value = "SELECT ID_RESPONSABLE, NOMBRE, CONTACTO, VETERINARIA_ID "+
			"FROM RESPONSABLE WHERE UPPER(NOMBER) = UPPER(:nombre)")
	public Responsables withOutDuplicate(String nombre);
}
