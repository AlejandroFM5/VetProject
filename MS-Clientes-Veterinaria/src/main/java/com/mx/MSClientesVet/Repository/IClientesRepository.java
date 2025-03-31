package com.mx.MSClientesVet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.MSClientesVet.Entity.Clientes;

@Repository
public interface IClientesRepository extends JpaRepository<Clientes, Long>{
	@Query(nativeQuery = true, 
			value = "SELECT ID_CLIENTE, NOMBRE, DIRECCION, CONTACTO "
			+"FROM CLIENTES "
			+"WHERE UPPER(NOMBRE) = UPPER(:nombre) ")
	public Clientes withOutDuplicates(String nombre);
}
