package com.mx.CrudPeliculasJPA.servicio;

import java.util.List;

import com.mx.CrudPeliculasJPA.dominio.Peliculas;

public interface MetodosPeliculas {
	public void guardar(Peliculas pelicula);

	public void editar(Peliculas pelicula);

	public void eliminar(Peliculas pelicula);

	public Peliculas buscar(Peliculas pelicula);
	
	public Peliculas buscarAtributo(Peliculas pelicula);

	public List<Peliculas> listarAtributo(Peliculas pelicula);

	public List<Peliculas> listarCaracter(String texto);  

	public List<Peliculas> listar();

	public Peliculas buscarMasCaro();

	public Peliculas buscarMasBarato();

	public Peliculas ContarPeliculas(Peliculas pelicula);
}
