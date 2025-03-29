package com.mx.MSGestionVeterinaria.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mx.MSGestionVeterinaria.Entity.GestionVeterinaria;
import com.mx.MSGestionVeterinaria.Service.GestionVeterinariaServiceImpl;

public class VeterinariaWSTest {
	@InjectMocks//INYECTA LOS MOCKS PARA LA CLASE ACTUAL
	private GestionVeterinariaWS vetWS;
	
	@Mock 
	private GestionVeterinariaServiceImpl service;
	
	private GestionVeterinaria vet1;
	private GestionVeterinaria vet2;
	
	@BeforeEach//INDICA QUE ESTE METODO SE EJECUTARA ANTES DE CADA PRUEBA
	void setUp() {
		MockitoAnnotations.openMocks(this);
		//vet1 = new GestionVeterinaria(1000,"MedicanDog","Libertad",(long)10000000);
		//vet2 = new GestionVeterinaria(1001,"Vet","No address",(long)10000001);
	}
	@Test
	void testListar() {
		List<GestionVeterinaria> veterinarias = Arrays.asList(vet1,vet2);
			when(service.listVeterinarias()).thenReturn(veterinarias);
			
			ResponseEntity<?> response = vetWS.listVeterinarias();
			
			assertEquals(HttpStatus.OK, response.getStatusCode());
			assertEquals(veterinarias, response.getBody());
	}
	
	@Test
	void testBuscarId(){
		when(service.findVeterinariasById(vet1)).thenReturn(vet1);
		ResponseEntity<?> response = vetWS.findVeterinariasById(vet1);
		
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(vet1, response.getBody());
	}
	
	@Test
	void testBuscarIdNOTFOUND(){
		when(service.findVeterinariasById(vet1)).thenReturn(vet1);
		ResponseEntity<?> response = vetWS.findVeterinariasById(vet1);
		
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testGuardar() {
		when(service.saveNewVeterinaria(any(GestionVeterinaria.class))).thenReturn(vet1);
		ResponseEntity<?> response = vetWS.saveNewVeterinaria(vet1);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(vet1, response.getBody());
	}
	
}
