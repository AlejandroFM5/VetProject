package com.mx.MSMascotas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.MSMascotas.Entity.Mascotas;
import com.mx.MSMascotas.Feing.IClientesFeign;
import com.mx.MSMascotas.Feing.IGestionVeterinariaFeign;
import com.mx.MSMascotas.Feing.IResponsablesFeing;
import com.mx.MSMascotas.Models.Clientes;
import com.mx.MSMascotas.Models.GestionVeterinaria;
import com.mx.MSMascotas.Models.Responsables;
import com.mx.MSMascotas.Repository.IMascotasRepository;

@Service
public class MascotasServiceImpl implements IMascotasService{
	
	@Autowired
	private IMascotasRepository repository;
	
	@Autowired
	private IClientesFeign cltFng;
	
	@Autowired
	private IGestionVeterinariaFeign gtvtFng;
	
	@Autowired
	private IResponsablesFeing rpbFng;

	@Override
	public List<Mascotas> listMascotas() {
		return repository.findAll();
	}

	@Override
	public Mascotas findMascotaById(Mascotas mct) {
		return repository.findById(mct.getClienteId()).orElse(null);
	}

	@Override
	public Mascotas saveNewMascota(Mascotas mct) {
		return repository.save(mct);
	}

	@Override
	public Mascotas edithMascota(Mascotas mct) {
		Mascotas NewMct = this.findMascotaById(mct);
		if(NewMct!=null)
			return repository.save(mct);
		return null;
	}

	@Override
	public Mascotas removeMascota(Mascotas mct) {
		Mascotas delMct = this.findMascotaById(mct);
		if(delMct!=null) {
			repository.delete(mct);
			return mct;
		}
		return null;
	}

	
	/*IMPLEMENTACIONES DE CLIENTES*/
	
	public List<Clientes> listClient(){
		return cltFng.listClient();
	}
	
	public Clientes findClienteById(Clientes clnt){
		return cltFng.findClienteById(clnt);
	}
	
	public Clientes saveNewCliente(Clientes clnt){
		return cltFng.saveNewCliente(clnt);
	}
	
	public Clientes editCliente(Clientes clnt){
		return cltFng.editCliente(clnt);
	}
	
	public Clientes removeCliente(Clientes clnt){
		return cltFng.removeCliente(clnt);
	}
	
	
	/*IMPLEMENTACIONES DE RESPONSABLES*/
	public List<Responsables> listResponsables(){
		return rpbFng.listResponsables();
	}
	
	public Responsables findResponsableById(Responsables rpb){
		return rpbFng.findResponsableById(rpb);
	}
	public Responsables saveNewResponsable(Responsables rpb){
		return rpbFng.saveNewResponsable(rpb);
	}
	public Responsables edithResponsable(Responsables rpb){
		return rpbFng.edithResponsable(rpb);
	}
	
	public Responsables removeResponsable(Responsables rpb){
		return rpbFng.removeResponsable(rpb);
	}
	
	
	/*IMPLEMENTACIONES DE VETERINARIA*/
	public List<GestionVeterinaria> listVeterinarias(){
		return gtvtFng.listVeterinarias();
	}
	
	public GestionVeterinaria findVeterinariasById(GestionVeterinaria vtrn){
		return gtvtFng.findVeterinariasById(vtrn);
	}
	
	public GestionVeterinaria saveNewVeterinaria(GestionVeterinaria vtrn){
		return gtvtFng.saveNewVeterinaria(vtrn);
	}
	
	public GestionVeterinaria edithVeterinaria(GestionVeterinaria vtrn){
		return gtvtFng.edithVeterinaria(vtrn);
	}
	
	public GestionVeterinaria removeVeterinaria(GestionVeterinaria vtrn){
		return gtvtFng.removeVeterinaria(vtrn);
	}
	
	
	
	
	
	
	
	
}
