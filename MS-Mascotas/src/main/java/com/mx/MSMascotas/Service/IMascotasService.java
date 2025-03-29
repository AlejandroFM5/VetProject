package com.mx.MSMascotas.Service;

import java.util.List;

import com.mx.MSMascotas.Entity.Mascotas;
import com.mx.MSMascotas.Models.Clientes;

public interface IMascotasService {
	public List<Mascotas> listMascotas();
	public Mascotas findMascotaById(Mascotas mct);
	public Mascotas saveNewMascota(Mascotas mct);
	public Mascotas edithMascota(Mascotas mct);
	public Mascotas removeMascota(Mascotas mct);
}
