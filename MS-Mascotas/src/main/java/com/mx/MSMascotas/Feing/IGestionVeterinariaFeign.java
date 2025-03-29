package com.mx.MSMascotas.Feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.MSMascotas.Models.GestionVeterinaria;

@FeignClient(name="MS-GestionVeterinaria", url="http://localhost:8204", path="/gestion")
public interface IGestionVeterinariaFeign {
	@GetMapping("/listar")
	public List<GestionVeterinaria> listVeterinarias();
	@PostMapping("/buscar-id")
	public GestionVeterinaria findVeterinariasById(@RequestBody GestionVeterinaria vtrn);
	@PostMapping("/guardar")
	public GestionVeterinaria saveNewVeterinaria(@RequestBody GestionVeterinaria vtrn);
	@PutMapping("/editar")
	public GestionVeterinaria edithVeterinaria(@RequestBody GestionVeterinaria vtrn);
	@DeleteMapping("/eliminar")
	public GestionVeterinaria removeVeterinaria(@RequestBody GestionVeterinaria vtrn);
}
