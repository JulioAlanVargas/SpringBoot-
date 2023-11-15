package com.mx.CrudPeliculasJPA.servicio;

import java.util.List;

import com.mx.CrudPeliculasJPA.dominio.Productoras;

public interface MetodosProductora {
	public void guardar(Productoras productora);

	public void editar(Productoras productora);

	public void eliminar(Productoras productora);

	public Productoras buscar(Productoras productora);
	
	public Productoras buscarAtributo(Productoras productora);

	public List<Productoras> listarAtributo(Productoras productora);

	public List<Productoras> listarCaracter(String texto);  

	public List<Productoras> listar();
}
