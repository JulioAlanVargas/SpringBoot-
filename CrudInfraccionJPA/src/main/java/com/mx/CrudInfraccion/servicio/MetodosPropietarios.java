package com.mx.CrudInfraccion.servicio;

import java.util.List;

import com.mx.CrudInfraccion.dominio.Propietarios;


public interface MetodosPropietarios {
	public void guardar(Propietarios propietario);

	public void editar(Propietarios propietario);

	public void eliminar(Propietarios propietario);

	public Propietarios buscar(Propietarios propietario);

	public List<Propietarios> listarDireccionApp(Propietarios propietario);

	public List<Propietarios> listarAtributo(String texto);  

	public List<Propietarios> listar();
}
