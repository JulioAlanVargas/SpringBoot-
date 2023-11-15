package com.mx.CrudPeliculasJPA.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.CrudPeliculasJPA.dominio.Peliculas;

import jakarta.transaction.Transactional;

public interface PeliculasDao extends JpaRepository<Peliculas, Integer> {

// guardar -> save() 
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "INSERT INTO PELICULAS_P VALUES(:ID,:TITULO,:FECHA_ESTRENO,:PRODUCTORA,:DIRECTOR,:GENERO,:DURACION,:PRECIO,:ID_PRODUCTORA)")
	void guardar(@Param("ID") int id, @Param("TITULO") String titulo, @Param("FECHA_ESTRENO") Date fechaEstreno,
			@Param("PRODUCTORA") String productora, @Param("DIRECTOR") String director, @Param("GENERO") String genero,
			@Param("DURACION") String duracion, @Param("PRECIO") double precio,
			@Param("ID_PRODUCTORA") int id_productora);

//editar
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE PELICULAS_P SET TITULO = :TITULO, FECHA_ESTRENO = :FECHA_ESTRENO, PRODUCTORA = :PRODUCTORA, DIRECTOR = :DIRECTOR, GENERO = :GENERO, DURACION = :DURACION, PRECIO = :PRECIO, ID_PRODUCTORA = :ID_PRODUCTORA WHERE ID = :ID")
	void editar(@Param("ID") int id, @Param("TITULO") String titulo, @Param("FECHA_ESTRENO") Date fechaEstreno,
			@Param("PRODUCTORA") String productora, @Param("DIRECTOR") String director, @Param("GENERO") String genero,
			@Param("DURACION") String duracion, @Param("PRECIO") double precio,
			@Param("ID_PRODUCTORA") int id_productora);

// buscar por titulo
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P WHERE TITULO=:TITULO")
	Peliculas buscarXTitulo(@Param("TITULO") String titulo);

// buscar por duracion
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P WHERE DURACION=:DURACION")
	Peliculas buscarXDuracion(@Param("DURACION") String duracion);

// buscar por precio
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P WHERE PRECIO=:PRECIO")
	Peliculas buscarXPrecio(@Param("PRECIO") double precio);

// buscar por direccion
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P WHERE FECHA_ESTRENO=:FECHA_ESTRENO")
	Peliculas buscarXFecha(@Param("FECHA_ESTRENO") Date fechaEstreno);

// buscar por genero o director
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P WHERE GENERO=:GENERO OR  DIRECTOR=:DIRECTOR")
	Peliculas buscarXGeneroDirector(@Param("GENERO") String genero, @Param("DIRECTOR") String director);

// eliminar por id
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM PELICULAS_P WHERE ID=:ID")
	void eliminarId(@Param("ID") int id);

// eliminar por titulo
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM PELICULAS_P WHERE TITULO=:TITULO")
	void eliminarNombre(@Param("TITULO") String titulo);

// listar por genero
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P WHERE GENERO=:GENERO")
	List<Peliculas> listarGenero(@Param("GENERO") String genero);

// listar por director
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P WHERE DIRECTOR=:DIRECTOR")
	List<Peliculas> listarDirector(@Param("DIRECTOR") String director);

// listar por Caracter
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P WHERE TITULO LIKE %?1% OR GENERO LIKE %?1%")
	List<Peliculas> listarCaracter(String texto);

// listar normal
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P")
	List<Peliculas> listar();

// contar cuantas peliculas por genero
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM PELICULAS_P WHERE GENERO=:GENERO")
	Peliculas contarGenero(@Param("GENERO") String genero);

// buscar pelicula mas cara
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P WHERE PRECIO = (SELECT M(PRECIO) FROM PELICULAS_P)")
	Peliculas buscarMasCara();

// buscar pelicula mas economica
	@Query(nativeQuery = true, value = "SELECT * FROM PELICULAS_P WHERE PRECIO = (SELECT MIN(PRECIO) FROM PELICULAS_P)")
	Peliculas buscarMasBarata();
}
