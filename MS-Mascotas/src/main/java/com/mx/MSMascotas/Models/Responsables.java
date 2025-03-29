package com.mx.MSMascotas.Models;

import lombok.Data;

@Data
public class Responsables {
	private long idResponsable;
	private String nombre;
	private long contacto;
	
	private long veterinariaId;
}
