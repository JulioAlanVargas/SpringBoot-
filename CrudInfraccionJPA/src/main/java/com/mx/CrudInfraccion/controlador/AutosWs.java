package com.mx.CrudInfraccion.controlador;

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

import com.mx.CrudInfraccion.dominio.Autos;
import com.mx.CrudInfraccion.dominio.Propietarios;
import com.mx.CrudInfraccion.servicio.ImplementacionAutos;

@RestController
@RequestMapping(path = "AutosWs")
@CrossOrigin("*")
public class AutosWs {
	@Autowired
	ImplementacionAutos imp;

	// http://localhost:9000/AutosWs/listar
	@GetMapping(path = "listar")
	public ResponseEntity<List<Autos>> listar() {
		List<Autos> lista = imp.listar();
		String mensaje = null;
		if (lista.isEmpty()) {
			mensaje = "No existen autos en el corrralon";
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listar());
	}

	// http://localhost:9000/AutosWs/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Autos auto) {
		String mensaje = null;
		imp.guardar(auto);
		mensaje = "Guardado";
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
	}

	// http://localhost:9000/AutosWs/editar
	@PostMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Autos auto) {
		String mensaje = null;
		imp.editar(auto);
		mensaje = "Editado";
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
	}

	// http://localhost:9000/AutosWs/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Autos auto) {
		String mensaje = null;
		imp.eliminar(auto);
		mensaje = "Eliminado";
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
	}

	// http://localhost:9000/AutosWs/buscar
	@PostMapping(path = "buscar")
	public ResponseEntity<?> buscar(@RequestBody Autos auto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.buscar(auto));
	}

	// http://localhost:9000/AutosWs/buscarAtributo
	@PostMapping(path = "buscarAtributo")
	public ResponseEntity<?> buscarAtributo(@RequestBody Autos auto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.buscarAtributo(auto));
	}

	// http://localhost:9000/AutosWs/listarMarcaModelo
	@PostMapping(path = "listarMarcaModelo")
	public ResponseEntity<?> listarMarcaModelo(@RequestBody Autos auto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listarMarcaOModelo(auto));
	}

	// http://localhost:9000/AutosWs/listarAtributo
	@PostMapping(path = "listarAtributo")
	public ResponseEntity<?> listarAtributo(@RequestBody String texto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listarAtributo(texto));
	}

	// http://localhost:9000/AutosWs/listarPropietario
	@GetMapping(path = "listarPropietario")
	public ResponseEntity<?> listarPropietario(@RequestBody Propietarios propietario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listarPropietario(propietario));
	}

}
