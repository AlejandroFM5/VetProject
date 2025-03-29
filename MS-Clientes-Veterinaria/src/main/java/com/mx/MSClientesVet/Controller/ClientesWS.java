package com.mx.MSClientesVet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.MSClientesVet.Entity.Clientes;
import com.mx.MSClientesVet.Service.ClientesServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClientesWS {
	//NOTE : TODAS LAS IMPLEMENTACIONES USARAN PATH_VARIABLE o REQUEST_BODY EN ESTE MICROSERVICIO
	
	@Autowired
	private ClientesServiceImpl service;	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listClient(){
		List<Clientes> clnt = service.listClient();
		if(clnt.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(clnt);
	}
	
	@PostMapping("/buscar-id")
	public ResponseEntity<?> findClienteById(@RequestBody Clientes clnt){
		Clientes saveClnt = service.findClienteById(clnt);
		if(clnt != null)
			return ResponseEntity.status(HttpStatus.OK).body(clnt);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> saveNewCliente(@RequestBody Clientes clnt){
		Clientes NewClnt = service.saveNewCliente(clnt);
		if(NewClnt != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(clnt);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping("/editar")
	public ResponseEntity<?> editCliente(@RequestBody Clientes clnt){
		Clientes NewClnt = service.findClienteById(clnt);
		if(NewClnt != null)
			if(service.editCliente(clnt)!=null)
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(clnt);
			else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> removeCliente(@RequestBody Clientes clnt){
		Clientes delClnt = service.findClienteById(clnt);
		if(delClnt != null) 
			if(service.removeCliente(clnt)!= null)
				return ResponseEntity.status(HttpStatus.OK).body(clnt);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clnt);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
