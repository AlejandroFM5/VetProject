package com.mx.MSResponsables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.MSResponsables.Entity.Responsables;

@Repository
public interface IResponsablesRepository extends JpaRepository<Responsables, Long>{

}
