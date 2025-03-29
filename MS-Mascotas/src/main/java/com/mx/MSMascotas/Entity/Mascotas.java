package com.mx.MSMascotas.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="MASCOTA")
public class Mascotas {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_MASCOTA")
	@SequenceGenerator(name="SEQ_ID_MASCOTA", sequenceName = "S_ID_MASCOTA", allocationSize = 1)
	private long idMascota;
	private String nombre;
	private String raza;
	private int edad;
	private String razonCita;
	

	private long clienteId;
	

	private long responsableId;
	

	private long veterinariaId;
}
