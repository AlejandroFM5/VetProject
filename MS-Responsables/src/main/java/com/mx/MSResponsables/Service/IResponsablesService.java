package com.mx.MSResponsables.Service;

import java.util.List;

import com.mx.MSResponsables.Entity.Responsables;

public interface IResponsablesService {
	public List<Responsables> listResponsables();
	public Responsables findResponsableById(Responsables rpb);
	public Responsables saveNewResponsable(Responsables rpb);
	public Responsables edithResponsable(Responsables rpb);
	public Responsables removeResponsable(Responsables rpb);
}
