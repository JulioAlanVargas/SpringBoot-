package com.mx.CrudPeliculasJPA.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudPeliculasJPA.dao.ProductorasDao;
import com.mx.CrudPeliculasJPA.dominio.Productoras;

@Service
public class ImpProductora implements MetodosProductora {
	@Autowired
	ProductorasDao dao;

	@Override
	public void guardar(Productoras productora) {
		// TODO Auto-generated method stub
		dao.save(productora);
		// dao.guardar(productora.getMatricula(), productora.getMarca(),
		// productora.getModelo(), productora.getColor(), productora.getTipoAuto(),
		// auto.getValorAuto(), auto.getPropietario().getCodigo());
	}

	@Override
	public void editar(Productoras productora) {
		// TODO Auto-generated method stub
		dao.save(productora);
	}

	@Override
	public void eliminar(Productoras productora) {
		// TODO Auto-generated method stub
		if (productora.getId() == 0) {
			dao.eliminarId(productora.getId());
		} else if (productora.getNombreProductora() != null) {
			dao.eliminarNombre(productora.getNombreProductora());
		}
	}

	@Override
	public Productoras buscar(Productoras productora) {
		// TODO Auto-generated method stub
		Productoras prod = null;
		if (productora.getNombreProductora() != null) {
			prod = dao.buscarXNombre(productora.getNombreProductora());
		} else if (productora.getPais() != null) {
			prod = dao.buscarXPais(productora.getPais());
		} else if (productora.getAniosMercado() != null) {
			prod = dao.buscarXAniosMercado(productora.getAniosMercado());
		} else if (productora.getDireccion() != null) {
			prod = dao.buscarXDireccion(productora.getDireccion());
		}

		return prod;
	}

	@Override
	public Productoras buscarAtributo(Productoras productora) {
		// TODO Auto-generated method stub
		return dao.buscarXContactoCantidad(productora.getContacto(), productora.getCantidadPeliculas());
	}

	@Override
	public List<Productoras> listarAtributo(Productoras productora) {
		// TODO Auto-generated method stub
		List<Productoras> lista = new ArrayList<>();
		if (productora.getDireccion() != null) {
			lista = dao.listarDireccion(productora.getDireccion());
		} else if (productora.getPais() != null) {
			lista = dao.listarPais(productora.getPais());
		}

		return lista;
	}

	@Override
	public List<Productoras> listarCaracter(String texto) {
		// TODO Auto-generated method stub
		List<Productoras> lista = new ArrayList<>();
		if (dao.listarCaracter(texto) != null) {
			lista.addAll(dao.listarCaracter(texto));
		}
		return lista;
	}

	@Override
	public List<Productoras> listar() {
		// TODO Auto-generated method stub
		return dao.listar();
	}

}
