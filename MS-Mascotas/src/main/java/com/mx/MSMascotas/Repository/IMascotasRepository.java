package com.mx.MSMascotas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.MSMascotas.Entity.Mascotas;

@Repository
public interface IMascotasRepository extends JpaRepository<Mascotas, Long>{

}
