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

import com.mx.CrudInfraccion.dominio.Propietarios;
import com.mx.CrudInfraccion.servicio.ImpPropietarios;

@RestController
@RequestMapping(path = "PropietariosWs")
@CrossOrigin("*")
public class PropietariosWs {
	@Autowired
	ImpPropietarios imp;

	// http://localhost:9000/PropietariosWs/listar
	@GetMapping(path = "listar")
	public ResponseEntity<List<Propietarios>> listar() {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listar());
	}

	// http://localhost:9000/PropietariosWs/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Propietarios propietario) {
		String mensaje = null;
		imp.guardar(propietario);
		mensaje = "Guardado";
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
	}
	// http://localhost:9000/PropietariosWs/editar
		@PostMapping(path = "editar")
		public ResponseEntity<?> editar(@RequestBody Propietarios propietario) {
			String mensaje = null;
			imp.editar(propietario);
			mensaje = "Editado";
			return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
		}

	// http://localhost:9000/PropietariosWs/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<?> eliminar(@RequestBody Propietarios propietario) {
		String mensaje = null;
		imp.eliminar(propietario);
		mensaje = "Eliminado";
		return new ResponseEntity<String>(mensaje, HttpStatus.CREATED);
	}

	// http://localhost:9000/PropietariosWs/buscar
	
	//SI HAY 2 IGUALES MARCARA ERROR YA QUE ESTA RECIBIENDO 2 OBJETOS Y SOLO PUEDE RETORNAR 1
	@PostMapping(path = "buscar")
	public ResponseEntity<?> buscar(@RequestBody Propietarios propietario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.buscar(propietario));
	}

	// http://localhost:9000/PropietariosWs/listarDireccionApp
	@PostMapping(path = "listarDireccionApp")
	public ResponseEntity<?> listarDireccionApp(@RequestBody Propietarios propietario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listarDireccionApp(propietario));
	}

	// http://localhost:9000/PropietariosWs/listarAtributo
	@PostMapping(path = "listarAtributo")
	public ResponseEntity<?> listarAtributo(@RequestBody String texto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(imp.listarAtributo(texto));
	}
}
