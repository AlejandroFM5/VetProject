package com.mx.MSGestionVeterinaria.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.MSGestionVeterinaria.Entity.GestionVeterinaria;
import com.mx.MSGestionVeterinaria.Repository.IGestionTiendaRepository;

@Service
public class GestionVeterinariaServiceImpl implements IGestionVeterinariaService{
	
	//INYECCION DE DEPENDENCIAS
	@Autowired
	private IGestionTiendaRepository repository;

	@Override
	public List<GestionVeterinaria> listVeterinarias() {
		return repository.findAll();
	}

	@Override
	public GestionVeterinaria findVeterinariasById(GestionVeterinaria vtrn) {
		return repository.findById(vtrn.getIdVeterinaria()).orElse(null);
	}

	@Override
	public GestionVeterinaria saveNewVeterinaria(GestionVeterinaria vtrn) {
		return repository.save(vtrn);
	}

	@Override
	public GestionVeterinaria edithVeterinaria(GestionVeterinaria vtrn) {
		GestionVeterinaria newVtrn = this.findVeterinariasById(vtrn);
		if(newVtrn != null)
			return repository.save(vtrn);
		return null;
	}

	@Override
	public GestionVeterinaria removeVeterinaria(GestionVeterinaria vtrn) {
		GestionVeterinaria delVtrn = this.findVeterinariasById(vtrn);
		if(delVtrn!=null) {
			repository.delete(delVtrn);
			return vtrn;
		}
		return null;
	}

}
