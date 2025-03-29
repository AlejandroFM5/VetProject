package com.mx.MSClientesVet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="CLIENTES")
public class Clientes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	private String nombre;
	private String direccion;
	private long contacto;
}
