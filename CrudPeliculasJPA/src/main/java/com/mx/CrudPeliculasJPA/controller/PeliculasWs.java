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

import com.mx.CrudPeliculasJPA.dominio.Peliculas;
import com.mx.CrudPeliculasJPA.servicio.ImpPeliculas;

@RestController
@RequestMapping(path = "PeliculasWs")
@CrossOrigin("*")
public class PeliculasWs {
	@Autowired
	ImpPeliculas imp;

	// http://localhost:9000/PeliculasWs/listar
	@GetMapping(path = "listar")
	public ResponseEntity<List<Peliculas>> listar() {
		List<Peliculas> lista = imp.listar();
		String mensaje = null;
		if (lista.isEmpty()) {
			mensaje = "No existen peliculas aun";
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listar());
	}

	// http://localhost:9000/PeliculasWs/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Peliculas pelicula) {
		String mensaje = null;
		imp.guardar(pelicula);
		mensaje = "Guardado";
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
	}

	// http://localhost:9000/PeliculasWs/editar
	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Peliculas pelicula) {
		String mensaje = null;
		imp.editar(pelicula);
		mensaje = "Editado";
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
	}

	// http://localhost:9000/PeliculasWs/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Peliculas pelicula) {
		String mensaje = null;
		imp.eliminar(pelicula);
		mensaje = "Eliminado";
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
	}

	// http://localhost:9000/PeliculasWs/buscar
	@PostMapping(path = "buscar")
	public ResponseEntity<?> buscar(@RequestBody Peliculas pelicula) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.buscar(pelicula));
	}

	// http://localhost:9000/PeliculasWs/buscarAtributo
	@PostMapping(path = "buscarAtributo")
	public ResponseEntity<?> buscarAtributo(@RequestBody Peliculas pelicula) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.buscarAtributo(pelicula));
	}

	// http://localhost:9000/PeliculasWs/listarAtributo
	@PostMapping(path = "listarAtributo")
	public ResponseEntity<?> listarAtributo(@RequestBody Peliculas pelicula) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listarAtributo(pelicula));
	}

	// http://localhost:9000/PeliculasWs/listarCaracter
	@PostMapping(path = "listarCaracter")
	public ResponseEntity<?> listarCaracter(@RequestBody String texto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listarCaracter(texto));
	}

	// http://localhost:9000/PeliculasWs/masCara
	@GetMapping(path = "masCara")
	public ResponseEntity<?> masCara() {
		List<Peliculas> lista = imp.listar();
		String mensaje = null;
		if (lista.isEmpty()) {
			mensaje = "No existen peliculas aun";
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.buscarMasCaro());
	}
	// http://localhost:9000/PeliculasWs/masBarata
	@GetMapping(path = "masBarata")
	public ResponseEntity<?> masBarata() {
		List<Peliculas> lista = imp.listar();
		String mensaje = null;
		if (lista.isEmpty()) {
			mensaje = "No existen peliculas aun";
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.buscarMasBarato());
	}

	// http://localhost:9000/PeliculasWs/contarGenero
	@PostMapping(path = "contarGenero")
	public ResponseEntity<?> contarGenero(@RequestBody Peliculas pelicula) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.ContarPeliculas(pelicula));
	}
}