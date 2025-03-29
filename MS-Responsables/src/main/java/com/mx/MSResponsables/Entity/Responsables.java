package com.mx.MSResponsables.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="RESPONSABLE")
public class Responsables {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_RESPONSABLE")
	@SequenceGenerator(name="SEQ_ID_RESPONSABLE", sequenceName = "S_ID_RESPONSABLE", allocationSize = 1)
	private long idResponsable;
	private String nombre;
	private long contacto;
	
	private long veterinariaId;
}
