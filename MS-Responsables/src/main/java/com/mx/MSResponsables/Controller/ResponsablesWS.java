package com.mx.MSResponsables.Controller;

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

import com.mx.MSResponsables.Entity.Responsables;
import com.mx.MSResponsables.Models.GestionVeterinaria;
import com.mx.MSResponsables.Service.ResponsablesServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/responsables")
@Tag(name="RESPONSABLES", description ="API PARA CRUD RESPONSABLES.")
public class ResponsablesWS {
	
	@Autowired
	private ResponsablesServiceImpl service;
	
	@GetMapping("/listar")
	@Operation(summary="", description="")
	public ResponseEntity<?> listResponsables(){
		List<Responsables> rpb = service.listResponsables();
		if(rpb.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(rpb);
	}
	
	@PostMapping("/buscar-id")
	public ResponseEntity<?> findResponsableById(@RequestBody Responsables rpb){
		Responsables findRpb = service.findResponsableById(rpb);
		if(findRpb != null)
			return ResponseEntity.status(HttpStatus.OK).body(rpb);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> saveNewResponsable(@RequestBody Responsables rpb){
		Responsables saveRpb = service.saveNewResponsable(rpb);
		if(saveRpb!=null)
			return ResponseEntity.status(HttpStatus.CREATED).body(rpb);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> edithResponsable(@RequestBody Responsables rpb){
		Responsables newRpb = service.findResponsableById(rpb);
		if(newRpb != null)
			if(service.edithResponsable(rpb)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(rpb);
			else
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> removeResponsable(@RequestBody Responsables rpb){
		Responsables delRpb = service.findResponsableById(rpb);
		if(delRpb!=null)
			if(service.removeResponsable(rpb)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(rpb);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	
	/*********************************REST*TEMPLATE*****************************************/
	/**********************************VETERINARIAS*****************************************/
	@GetMapping("/gestion/listar")
	public ResponseEntity<?> listVeterinarias(){
		List<GestionVeterinaria> vtr = service.listMascotas();
		if(vtr.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(vtr);
	}
	
	@PostMapping("/gestion/buscar-id")
	public ResponseEntity<?> findVeterinariasById(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria findVtr = service.findMascotaById(vtrn);
		if(findVtr!=null)
			return ResponseEntity.status(HttpStatus.OK).body(vtrn);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/gestion/guardar")
	public ResponseEntity<?> saveNewVeterinaria(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria findVtr = service.saveNewMascota(vtrn);
		if(findVtr!=null)
			return ResponseEntity.status(HttpStatus.CREATED).body(vtrn);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping("/gestion/editar")
	public ResponseEntity<?> edithVeterinaria(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria findVtr = service.findMascotaById(vtrn);
		if(findVtr != null)
			if(service.edithMascota(vtrn)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(vtrn);
			else
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/gestion/eliminar")
	public ResponseEntity<?> removeVeterinaria(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria findVtr = service.findMascotaById(vtrn);
		if(findVtr!=null)
			if(service.removeMascota(vtrn)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(vtrn);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
