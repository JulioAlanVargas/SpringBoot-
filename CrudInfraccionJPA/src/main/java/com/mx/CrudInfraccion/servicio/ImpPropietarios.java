package com.mx.CrudInfraccion.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudInfraccion.dao.PropietarioDao;
import com.mx.CrudInfraccion.dominio.Propietarios;

@Service
public class ImpPropietarios implements MetodosPropietarios{
	@Autowired
	PropietarioDao dao;
	@Override
	public void guardar(Propietarios propietario) {
		// TODO Auto-generated method stub
		dao.guardar(propietario.getCodigo(), propietario.getNombre(), propietario.getApp(), propietario.getDireccion(), propietario.getFechaInfraccion(), propietario.getTipoInfraccion(), propietario.getCostoInfraccion(), propietario.getUbicacionInfraccion());
		//dao.save(propietario);
	}

	@Override
	public void editar(Propietarios propietario) {
		// TODO Auto-generated method stub
		dao.editar(propietario.getCodigo(), propietario.getNombre(), propietario.getApp(), propietario.getDireccion(), propietario.getFechaInfraccion(), propietario.getTipoInfraccion(), propietario.getCostoInfraccion(), propietario.getUbicacionInfraccion());
		//dao.save(propietario);
	}

	@Override
	public void eliminar(Propietarios propietario) {
		// TODO Auto-generated method stub
		if (propietario.getCodigo() != null) {
			dao.eliminarCodigo(propietario.getCodigo());
		}else if (propietario.getNombre() != null) {
			dao.eliminarNombre(propietario.getNombre());
		}
	}

	@Override
	public Propietarios buscar(Propietarios propietario) {
		// TODO Auto-generated method stub
		Propietarios prop = null;
		
		if (propietario.getNombre() != null) {
			prop = dao.buscarXNombre(propietario.getNombre());
		}else if (propietario.getUbicacionInfraccion() != null) {
			prop = dao.buscarXUbicacion(propietario.getUbicacionInfraccion());
		} 
		return prop;
	}

	@Override
	public List<Propietarios> listarDireccionApp(Propietarios propietario) {
		// TODO Auto-generated method stub
		List<Propietarios> lista = new ArrayList<>();
		if (propietario.getDireccion() != null) {
			lista = dao.listarDireccion(propietario.getDireccion());
		}else if (propietario.getApp() != null) {
			lista = dao.listarApp(propietario.getApp());
		}
		
		return lista;
	}

	@Override
	public List<Propietarios> listarAtributo(String texto) {
		// TODO Auto-generated method stub
		List<Propietarios> lista = new ArrayList<>();
		if (dao.listarAtributo(texto) != null) {
			lista.addAll(dao.listarAtributo(texto));
		}
		return lista;
	}

	@Override
	public List<Propietarios> listar() {
		// TODO Auto-generated method stub
		return dao.listar();
	}

}
