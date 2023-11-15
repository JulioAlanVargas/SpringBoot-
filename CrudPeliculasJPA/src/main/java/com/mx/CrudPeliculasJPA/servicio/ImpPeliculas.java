package com.mx.CrudPeliculasJPA.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudPeliculasJPA.dao.PeliculasDao;
import com.mx.CrudPeliculasJPA.dominio.Peliculas;
@Service
public class ImpPeliculas implements MetodosPeliculas{
	
	@Autowired
	PeliculasDao dao;
	@Override
	public void guardar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		dao.save(pelicula);
		dao.guardar(pelicula.getId(), pelicula.getTitulo(), pelicula.getFechaEstreno(), pelicula.getProductora(), pelicula.getDirector(), pelicula.getGenero(), pelicula.getDuracion(), pelicula.getPrecio(), pelicula.getProductoras().getId());
}

	@Override
	public void editar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		dao.save(pelicula);
	}

	@Override
	public void eliminar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		if (pelicula.getId() == 0) {
			dao.eliminarId(pelicula.getId());
		} else if (pelicula.getTitulo() != null) {
			dao.eliminarNombre(pelicula.getTitulo());
		}
	}

	@Override
	public Peliculas buscar(Peliculas pelicula) {
		// TODO Auto-generated method stub
		Peliculas prod = null;
		if (pelicula.getTitulo() != null ) {
			prod = dao.buscarXTitulo(pelicula.getTitulo());
		}else if (pelicula.getDuracion() != null) {
			prod = dao.buscarXDuracion(pelicula.getDuracion());
		}else if (pelicula.getPrecio() == 0) {
			prod = dao.buscarXPrecio(pelicula.getPrecio());
		}else if (pelicula.getFechaEstreno() != null) {
			prod = dao.buscarXFecha(pelicula.getFechaEstreno());
		}
		
		return prod;
	}
	
	@Override
	public Peliculas buscarAtributo(Peliculas pelicula) {
		// TODO Auto-generated method stub
		return dao.buscarXGeneroDirector(pelicula.getGenero(), pelicula.getDirector());
	}

	@Override
	public List<Peliculas> listarAtributo(Peliculas pelicula) {
		// TODO Auto-generated method stub
		List<Peliculas> lista = new ArrayList<>();
		if (pelicula.getGenero() != null) {
			lista = dao.listarGenero(pelicula.getGenero());
		}else if (pelicula.getDirector() != null) {
			lista = dao.listarDirector(pelicula.getDirector());
		}
		
		return lista;
	}

	
	@Override
	public List<Peliculas> listarCaracter(String texto) {
		// TODO Auto-generated method stub
		List<Peliculas> lista = new ArrayList<>();
		if (dao.listarCaracter(texto) != null) {
			lista.addAll(dao.listarCaracter(texto));
		}
		return lista;
	}

	@Override
	public List<Peliculas> listar() {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Peliculas buscarMasCaro() {
		// TODO Auto-generated method stub
		return dao.buscarMasCara();
	}

	@Override
	public Peliculas buscarMasBarato() {
		// TODO Auto-generated method stub
		return dao.buscarMasBarata();
	}

	@Override
	public Peliculas ContarPeliculas(Peliculas pelicula) {
		// TODO Auto-generated method stub
		return dao.contarGenero(pelicula.getGenero());
	}

}
