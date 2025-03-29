package com.mx.MSClientesVet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.MSClientesVet.Entity.Clientes;
import com.mx.MSClientesVet.Repository.IClientesRepository;

@Service
public class ClientesServiceImpl implements IClientesService{
	
	//INYECCION DE DEPENDENCIAS
	@Autowired
	private IClientesRepository repository;

	@Override
	public List<Clientes> listClient() {
		return repository.findAll();
	}

	@Override
	public Clientes findClienteById(Clientes clnt) {
		return repository.findById(clnt.getIdCliente()).orElse(null);
	}

	@Override
	public Clientes saveNewCliente(Clientes clnt) {
		return repository.save(clnt);
	}

	@Override
	public Clientes editCliente(Clientes clnt) {
		Clientes auxClnt = this.findClienteById(clnt);
		if(auxClnt != null)
			return repository.save(clnt);
		return null;
	}

	@Override
	public Clientes removeCliente(Clientes clnt) {
		Clientes auxClnt = this.findClienteById(clnt);
		if(auxClnt != null) {
			repository.delete(clnt);
			return auxClnt;
		}
		return null;
	}

}
