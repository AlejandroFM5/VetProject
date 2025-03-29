package com.mx.MSMascotas.Controller;

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

import com.mx.MSMascotas.Entity.Mascotas;
import com.mx.MSMascotas.Models.Clientes;
import com.mx.MSMascotas.Models.GestionVeterinaria;
import com.mx.MSMascotas.Models.Responsables;
import com.mx.MSMascotas.Service.MascotasServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/mascotas")
public class MascotasWS {
	//NOTE : EN ESTE MICROSERVICIO SE USARAN PARAM Y PATH_VARIABLE MESCLADOS AL IGUAL QUE REQUEST_BODY
	@Autowired
	private MascotasServiceImpl service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listMascotas(){
		List<Mascotas> mct = service.listMascotas();
		if(mct.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(mct);
	}
	
	@PostMapping("/buscar-id")
	public ResponseEntity<?> findMascotaById(@RequestBody Mascotas mct){
		Mascotas findMct = service.findMascotaById(mct);
		if(findMct!=null)
			return ResponseEntity.status(HttpStatus.OK).body(mct);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> saveNewMascota(@RequestBody Mascotas mct){
		Mascotas newMct = service.saveNewMascota(mct);
		if(newMct!=null)
			return ResponseEntity.status(HttpStatus.CREATED).body(mct);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> edithMascota(@RequestBody Mascotas mct){
		Mascotas newMct = service.findMascotaById(mct);
		if(newMct != null)
			if(service.edithMascota(mct)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(mct);
			else
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> removeMascota(@RequestBody Mascotas mct){
		Mascotas delMct = service.findMascotaById(mct);
		if(delMct!=null)
			if(service.removeMascota(mct)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(mct);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	/*CONTROLLER CLIENTES*/
	@GetMapping("/clientes/listar")
	public ResponseEntity<?> listClient(){
		List<Clientes> clnt = service.listClient();
		if(clnt.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(clnt);
	}
	
	@PostMapping("/clientes/buscar-id")
	public ResponseEntity<?> findClienteById(@RequestBody Clientes clnt){
		Clientes saveClnt = service.findClienteById(clnt);
		if(saveClnt != null)
			return ResponseEntity.status(HttpStatus.OK).body(clnt);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/clientes/guardar")
	public ResponseEntity<?> saveNewCliente(@RequestBody Clientes clnt){
		Clientes NewClnt = service.saveNewCliente(clnt);
		if(NewClnt != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(clnt);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping("/clientes/editar")
	public ResponseEntity<?> editCliente(@RequestBody Clientes clnt){
		Clientes NewClnt = service.findClienteById(clnt);
		if(NewClnt != null)
			if(service.editCliente(clnt)!=null)
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(clnt);
			else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/clientes/eliminar")
	public ResponseEntity<?> removeCliente(@RequestBody Clientes clnt){
		Clientes delClnt = service.findClienteById(clnt);
		if(delClnt != null) 
			if(service.removeCliente(clnt)!= null)
				return ResponseEntity.status(HttpStatus.OK).body(clnt);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clnt);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	/*CONTROLLER RESPONSABLES*/

	@GetMapping("/responsables/listar")
	public ResponseEntity<?> listResponsables(){
		List<Responsables> rpb = service.listResponsables();
		if(rpb.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(rpb);
	}
	
	@PostMapping("/responsables/buscar-id")
	public ResponseEntity<?> findResponsableById(@RequestBody Responsables rpb){
		Responsables findRpb = service.findResponsableById(rpb);
		if(findRpb != null)
			return ResponseEntity.status(HttpStatus.OK).body(rpb);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/responsables/guardar")
	public ResponseEntity<?> saveNewResponsable(@RequestBody Responsables rpb){
		Responsables saveRpb = service.saveNewResponsable(rpb);
		if(saveRpb!=null)
			return ResponseEntity.status(HttpStatus.CREATED).body(rpb);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping("/responsables/editar")
	public ResponseEntity<?> edithResponsable(@RequestBody Responsables rpb){
		Responsables newRpb = service.findResponsableById(rpb);
		if(newRpb != null)
			if(service.edithResponsable(rpb)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(rpb);
			else
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/responsables/eliminar")
	public ResponseEntity<?> removeResponsable(@RequestBody Responsables rpb){
		Responsables delRpb = service.findResponsableById(rpb);
		if(delRpb!=null)
			if(service.removeResponsable(rpb)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(rpb);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	/*CONTROLLER VETERINARIAS*/
	@GetMapping("/gestion/listar")
	@Operation(summary="MOSTRAR LAS VETERINARIAS", description="Devuelve una lista de las veterinarias alamacenadas.")
	public ResponseEntity<?> listVeterinarias(){
		List<GestionVeterinaria> vtr = service.listVeterinarias();
		if(vtr.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(vtr);
	}
	
	@PostMapping("/gestion/buscar-id")
	@Operation(summary="BUSCAR VETERINARIA", description="Devuelve una VETERINARIA de las veterinarias alamacenadas, obtenida o buscada por su ID desde el URL.")
	public ResponseEntity<?> findVeterinariasById(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria findVtr = service.findVeterinariasById(vtrn);
		if(findVtr!=null)
			return ResponseEntity.status(HttpStatus.OK).body(vtrn);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/gestion/guardar")
	@Operation(summary="GUARDA UNA VETERINARIA", description="Guarda una nueva Veterinaria.")
	public ResponseEntity<?> saveNewVeterinaria(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria findVtr = service.saveNewVeterinaria(vtrn);
		if(findVtr!=null)
			return ResponseEntity.status(HttpStatus.CREATED).body(vtrn);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping("/gestion/eliminar")
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
	
	@DeleteMapping("/gestion")
	public ResponseEntity<?> removeVeterinaria(@RequestBody GestionVeterinaria vtrn) {
		GestionVeterinaria findVtr = service.findVeterinariasById(vtrn);
		if(findVtr!=null)
			if(service.removeVeterinaria(vtrn)!=null)
				return ResponseEntity.status(HttpStatus.OK).body(vtrn);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
}
