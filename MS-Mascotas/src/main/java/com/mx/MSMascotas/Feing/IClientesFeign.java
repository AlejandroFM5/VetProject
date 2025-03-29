package com.mx.MSMascotas.Feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.MSMascotas.Models.Clientes;

@FeignClient(name="MS-Clientes-Veterinaria", url="http://localhost:8201", path="/clientes")
public interface IClientesFeign {
	
	@GetMapping("/listar")
	public List<Clientes> listClient();
	
	@PostMapping("/buscar-id")
	public Clientes findClienteById(@RequestBody Clientes clt);
	
	@PostMapping("/guardar")
	public Clientes saveNewCliente(@RequestBody Clientes clt);
	
	@PutMapping("/editar")
	public Clientes editCliente(@RequestBody Clientes clt);
	
	@DeleteMapping("/eliminar")
	public Clientes removeCliente(@RequestBody Clientes clts);
}
