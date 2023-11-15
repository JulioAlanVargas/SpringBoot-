package com.mx.CrudInfraccion.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudInfraccion.dao.AutosDao;
import com.mx.CrudInfraccion.dominio.Autos;
import com.mx.CrudInfraccion.dominio.Propietarios;

@Service
public class ImplementacionAutos implements MetodosAutos{
	
	@Autowired
	AutosDao dao;
	@Override
	public void guardar(Autos auto) {
		// TODO Auto-generated method stub
		dao.save(auto);
		//dao.guardar(auto.getMatricula(), auto.getMarca(), auto.getModelo(), auto.getColor(), auto.getTipoAuto(), auto.getValorAuto(), auto.getPropietario().getCodigo());
	}

	@Override
	public void editar(Autos auto) {
		// TODO Auto-generated method stub
		dao.save(auto);
	}

	@Override
	public void eliminar(Autos auto) {
		// TODO Auto-generated method stub
		if (auto.getMarca() != null) {
			dao.eliminarMarca(auto.getMarca());
		} else if (auto.getMatricula() != null) {
			dao.eliminarMatricula(auto.getMatricula());
		}
	}

	@Override
	public Autos buscar(Autos auto) {
		// TODO Auto-generated method stub
		Autos aut = null;
		if (auto.getMarca() != null ) {
			aut = dao.buscarXMarca(auto.getMarca());
		}else if (auto.getModelo() != null) {
			aut = dao.buscarXModelo(auto.getModelo());
		}
		
		return aut;
	}
	
	@Override
	public Autos buscarAtributo(Autos auto) {
		// TODO Auto-generated method stub
		return dao.buscarPorTipoOColor(auto.getTipoAuto(), auto.getColor());
	}

	@Override
	public List<Autos> listarMarcaOModelo(Autos auto) {
		// TODO Auto-generated method stub
		List<Autos> lista = new ArrayList<>();
		if (auto.getMarca() != null) {
			lista = dao.listarMarca(auto.getMarca());
		}else if (auto.getModelo() != null) {
			lista = dao.listarModelo(auto.getModelo());
		}
		
		return lista;
	}
	
	@Override
	public List<Autos> listarAtributo(String texto) {
		// TODO Auto-generated method stub
		List<Autos> lista = new ArrayList<>();
		if (dao.listarAtributo(texto) != null) {
			lista.addAll(dao.listarAtributo(texto));
		}
		return lista;
	}

	@Override
	public List<Autos> listar() {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	
	public List<Autos> listarPropietario(Propietarios propietario) {
		// TODO Auto-generated method stub
		return dao.listarPropietario(propietario.getCodigo());
	}
	

}
