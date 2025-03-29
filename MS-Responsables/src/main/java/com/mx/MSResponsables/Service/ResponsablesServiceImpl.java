package com.mx.MSResponsables.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.MSResponsables.Entity.Responsables;
import com.mx.MSResponsables.Models.GestionVeterinaria;
import com.mx.MSResponsables.Repository.IResponsablesRepository;

@Service
public class ResponsablesServiceImpl implements IResponsablesService{
	
	@Autowired
	private IResponsablesRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Responsables> listResponsables() {
		return repository.findAll();
	}

	@Override
	public Responsables findResponsableById(Responsables rpb) {
		return repository.findById(rpb.getIdResponsable()).orElse(null);
	}

	@Override
	public Responsables saveNewResponsable(Responsables rpb) {
		return repository.save(rpb);
	}

	@Override
	public Responsables edithResponsable(Responsables rpb) {
		Responsables newRpb = this.findResponsableById(rpb);
		if(newRpb != null)
			return repository.save(rpb);
		return null;
	}

	@Override
	public Responsables removeResponsable(Responsables rpb) {
		Responsables delRpb = this.findResponsableById(rpb);
		if(delRpb != null) {
			repository.delete(rpb);
			return rpb;
		}
		return null;
	}
	
	//IMPLEMENTACIONES DE VETERINARIAS
		//METODOS CON REST TEMPLATE
		@SuppressWarnings("unchecked")
		public List<GestionVeterinaria> listMascotas(){
			return restTemplate.getForObject("http://localhost:8204/gestion/listar", List.class);
		}
		
		public GestionVeterinaria findMascotaById(GestionVeterinaria vtr){
			ResponseEntity<GestionVeterinaria> response = restTemplate.postForEntity("http://localhost:8204/gestion/buscar-id", vtr, GestionVeterinaria.class);
			return response.getBody();
		}
		public GestionVeterinaria saveNewMascota(GestionVeterinaria vtr){
			ResponseEntity<GestionVeterinaria> response = restTemplate.postForEntity("http://localhost:8204/gestion/guardar", vtr, GestionVeterinaria.class);
			return response.getBody();
		}
		public GestionVeterinaria edithMascota(GestionVeterinaria vtrn){
			//USER .. ???
			ResponseEntity<GestionVeterinaria> response = restTemplate.postForEntity("http://localhost:8204/gestion/editar", vtrn, GestionVeterinaria.class);
			return response.getBody();
		}
		public GestionVeterinaria removeMascota(GestionVeterinaria vtr){
			ResponseEntity<GestionVeterinaria> response = restTemplate.postForEntity("http://localhost:8204/gestion/eliminar", vtr, GestionVeterinaria.class);
			return response.getBody();
		}

}
