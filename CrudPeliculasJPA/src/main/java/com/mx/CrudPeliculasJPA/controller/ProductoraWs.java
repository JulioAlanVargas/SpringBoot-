package com.mx.CrudPeliculasJPA.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CrudPeliculasJPA.dominio.Productoras;
import com.mx.CrudPeliculasJPA.servicio.ImpProductora;


@RestController
@RequestMapping(path = "ProductorasWs")
@CrossOrigin("*")
public class ProductoraWs {
	@Autowired
	ImpProductora imp;

	// http://localhost:9000/ProductorasWs/listar
	@GetMapping(path = "listar")
	public ResponseEntity<List<Productoras>> listar() {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listar());
	}

	// http://localhost:9000/ProductorasWs/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Productoras productora) {
		String mensaje = null;
		imp.guardar(productora);
		mensaje = "Guardado";
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
	}
	// http://localhost:9000/ProductorasWs/editar
		@PostMapping(path = "editar")
		public ResponseEntity<?> editar(@RequestBody Productoras productora) {
			String mensaje = null;
			imp.editar(productora);
			mensaje = "Editado";
			return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
		}

	// http://localhost:9000/ProductorasWs/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Productoras productora) {
		String mensaje = null;
		imp.eliminar(productora);
		mensaje = "Eliminado";
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
	}

	// http://localhost:9000/ProductorasWs/buscar
	
	//SI HAY 2 IGUALES MARCARA ERROR YA QUE ESTA RECIBIENDO 2 OBJETOS Y SOLO PUEDE RETORNAR 1
	@PostMapping(path = "buscar")
	public ResponseEntity<?> buscar(@RequestBody Productoras productora) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.buscar(productora));
	}

	// http://localhost:9000/ProductorasWs/buscarAtributo
	@PostMapping(path = "buscarAtributo")
	public ResponseEntity<?> buscarAtributo(@RequestBody Productoras productora) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.buscarAtributo(productora));
	}

	// http://localhost:9000/PropietariosWs/listarAtributo
	@PostMapping(path = "listarAtributo")
	public ResponseEntity<?> listarAtributo(@RequestBody Productoras productora) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listarAtributo(productora));
	}

	// http://localhost:9000/PropietariosWs/listarCaracter
	@PostMapping(path = "listarCaracter")
	public ResponseEntity<?> listarCaracter(@RequestBody String texto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listarCaracter(texto));
	}
}
