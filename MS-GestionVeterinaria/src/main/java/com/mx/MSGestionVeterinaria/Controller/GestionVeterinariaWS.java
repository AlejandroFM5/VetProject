package com.mx.MSGestionVeterinaria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.MSGestionVeterinaria.Entity.GestionVeterinaria;
import com.mx.MSGestionVeterinaria.Service.GestionVeterinariaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Veterinarias", description ="API PARA GESTIONAR VERTERINARIAS.")
@RequestMapping("/gestion")
public class GestionVeterinariaWS {
	@Autowired
	private GestionVeterinariaServiceImpl service;
	
	
	@Operation(summary="MOSTRAR LAS VETERINARIAS", description="Devuelve una lista de las veterinarias alamacenadas.")
	@GetMapping("/listar")
	public ResponseEntity<?> listVeterinarias(){
		List<GestionVeterinaria> vtr = service.listVeterinarias();
		if(vtr.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(vtr);
	}
	
	@PostMapping("/buscar-id")
	@Operation(summary="BUSCAR VETERINARIA", description="Devuelve una VETERINARIA de las veterinarias alamacenadas, obtenida o buscada por su ID desde el URL.")
	public ResponseEntity<?> findVeterinariasById(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria findVtr = service.findVeterinariasById(vtrn);
		if(findVtr!=null)
			return ResponseEntity.status(HttpStatus.OK).body(vtrn);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/guardar")
	@Operation(summary="GUARDA UNA VETERINARIA", description="Guarda una nueva Veterinaria.")
	public ResponseEntity<?> saveNewVeterinaria(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria auxVtrn = service.withOutDuplicateName(vtrn);
		if(auxVtrn==null) {
			service.saveNewVeterinaria(vtrn);
			return ResponseEntity.status(HttpStatus.CREATED).body(vtrn);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping("/editar")
	@Operation(summary="ACTUALIZAR VETERINARIA", description="Recibe un Objeto y permite modificarlo.")
	public ResponseEntity<?> edithVeterinaria(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria findVtr = service.findVeterinariasById(vtrn);
		if(findVtr != null)
			if(service.edithVeterinaria(vtrn)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(vtrn);
			else
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> removeVeterinaria(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria findVtr = service.findVeterinariasById(vtrn);
		if(findVtr!=null)
			if(service.removeVeterinaria(vtrn)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(vtrn);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//ACCESO A SWAGGER
	//  : http://localhost:8204/swagger-ui.html
	
}
