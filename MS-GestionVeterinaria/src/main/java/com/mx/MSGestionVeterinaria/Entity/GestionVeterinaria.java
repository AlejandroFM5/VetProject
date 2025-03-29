package com.mx.MSGestionVeterinaria.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="VETERINARIA")
public class GestionVeterinaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVeterinaria;
	private String nombre;
	private String direccion;
	private long telefono;
}
