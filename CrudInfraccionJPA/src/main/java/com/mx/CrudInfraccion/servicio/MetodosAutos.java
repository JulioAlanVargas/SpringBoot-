package com.mx.CrudInfraccion.servicio;

import java.util.List;

import com.mx.CrudInfraccion.dominio.Autos;


public interface MetodosAutos {
	public void guardar(Autos auto);

	public void editar(Autos auto);

	public void eliminar(Autos auto);

	public Autos buscar(Autos auto);
	
	public Autos buscarAtributo(Autos auto);

	public List<Autos> listarMarcaOModelo(Autos auto);

	public List<Autos> listarAtributo(String texto);  

	public List<Autos> listar();
	
}
