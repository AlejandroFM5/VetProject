package com.mx.MSClientesVet.Service;

import java.util.List;

import com.mx.MSClientesVet.Entity.Clientes;

public interface IClientesService {
	public List<Clientes> listClient();
	public Clientes findClienteById(Clientes clnt);
	public Clientes saveNewCliente(Clientes clnt);
	public Clientes editCliente(Clientes clnt);
	public Clientes removeCliente(Clientes clnt);
}
