package com.mx.MSMascotas.Feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.MSMascotas.Models.Responsables;

@FeignClient(name="MS-Responsables", url="http://localhost:8203", path="/responsables")
public interface IResponsablesFeing {
	@GetMapping("/listar")
	public List<Responsables> listResponsables();
	
	@PostMapping("/buscar-id")
	public Responsables findResponsableById(@RequestBody Responsables rpb);
	
	@PostMapping("/guardar")
	public Responsables saveNewResponsable(@RequestBody Responsables rpb);
	
	@PutMapping("/editar")
	public Responsables edithResponsable(@RequestBody Responsables rpb);
	
	@DeleteMapping("/eliminar")
	public Responsables removeResponsable(@RequestBody Responsables rpb);
}
