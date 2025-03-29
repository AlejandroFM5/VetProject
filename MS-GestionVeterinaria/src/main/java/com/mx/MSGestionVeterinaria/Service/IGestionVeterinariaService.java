package com.mx.MSGestionVeterinaria.Service;

import java.util.List;

import com.mx.MSGestionVeterinaria.Entity.GestionVeterinaria;

public interface IGestionVeterinariaService {
	public List<GestionVeterinaria> listVeterinarias();
	public GestionVeterinaria findVeterinariasById(GestionVeterinaria vtrn);
	public GestionVeterinaria saveNewVeterinaria(GestionVeterinaria vtrn);
	public GestionVeterinaria edithVeterinaria(GestionVeterinaria vtrn);
	public GestionVeterinaria removeVeterinaria(GestionVeterinaria vtrn);
}
