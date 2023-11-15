package com.mx.CrudPeliculasJPA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.CrudPeliculasJPA.dominio.Productoras;

import jakarta.transaction.Transactional;

public interface ProductorasDao extends JpaRepository<Productoras, Integer>{
	
	// guardar -> save()
		@Transactional
		@Modifying
		@Query(nativeQuery = true, value = "INSERT INTO PRODUCTORAS VALUES(:ID,:NOMBRE_PRODUCTORA,:PAIS,:ANIOS_MERCADO,:DIRECCION,:CANTIDAD_PELICUAS,:CONTACTO)")
		void guardar(@Param("ID") int id, @Param("NOMBRE_PRODUCTORA") String nombreProductora, @Param("PAIS") String pais,
				@Param("ANIOS_MERCADO") int aniosMercado, @Param("DIRECCION") String direccion,
				@Param("CANTIDAD_PELICUAS") int cantidadPeliculas, @Param("CONTACTO") long contacto);

		//editar
		@Transactional
		@Modifying
		@Query(nativeQuery = true, value = "UPDATE PRODUCTORAS SET NOMBRE_PRODUCTORA = :NOMBRE_PRODUCTORA, PAIS = :PAIS, ANIOS_MERCADO = :ANIOS_MERCADO, DIRECCION = :DIRECCION, CANTIDAD_PELICUAS = :CANTIDAD_PELICUAS, CONTACTO = :CONTACTO, WHERE ID = :ID")
		void editar(@Param("ID") int id, @Param("NOMBRE_PRODUCTORA") String nombreProductora, @Param("PAIS") String pais,
				@Param("ANIOS_MERCADO") int aniosMercado, @Param("DIRECCION") String direccion,
				@Param("CANTIDAD_PELICUAS") int cantidadPeliculas, @Param("CONTACTO") long contacto);
		
		
		// buscar por nombre productora
		@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTORAS WHERE NOMBRE_PRODUCTORA=:NOMBRE_PRODUCTORA")
		public Productoras buscarXNombre(@Param("NOMBRE_PRODUCTORA") String nombreProductora);

		// buscar por pais
		@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTORAS WHERE PAIS=:PAIS")
		public Productoras buscarXPais(@Param("PAIS") String pais);

		// buscar por aniosMercado
		@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTORAS WHERE ANIOS_MERCADO=:ANIOS_MERCADO")
		public Productoras buscarXAniosMercado(@Param("ANIOS_MERCADO") String aniosMercado);

		// buscar por direccion
		@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTORAS WHERE DIRECCION=:DIRECCION")
		public Productoras buscarXDireccion(@Param("DIRECCION") String direccion);

		// buscar por contacto o cantidad peliculas
		@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTORAS WHERE CONTACTO = :CONTACTO OR CANTIDAD_PELICUAS = :CANTIDAD_PELICUAS")
		Productoras buscarXContactoCantidad(@Param("CONTACTO") long contacto, @Param("CANTIDAD_PELICUAS") int cantidadPeliculas);

		// eliminar por id
		@Transactional
		@Modifying
		@Query(nativeQuery = true, value = "DELETE FROM PRODUCTORAS WHERE ID=:ID")
		void eliminarId(@Param("ID") int id);

		// eliminar por nombre
		@Transactional
		@Modifying
		@Query(nativeQuery = true, value = "DELETE FROM PRODUCTORAS WHERE NOMBRE_PRODUCTORA=:NOMBRE_PRODUCTORA")
		void eliminarNombre(@Param("NOMBRE_PRODUCTORA") String nombreProductora);

		// listar por direccion
		@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTORAS WHERE DIRECCION=:DIRECCION")
		public List<Productoras> listarDireccion(@Param("DIRECCION") String direccion);

		// listar por pais
		@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTORAS WHERE PAIS=:PAIS")
		public List<Productoras> listarPais(@Param("PAIS") String pais);
		
		// listar por Caracter
		@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTORAS WHERE NOMBRE_PRODUCTORA LIKE %?1% OR PAIS LIKE %?1% OR CONTACTO LIKE %?1%")
		List<Productoras> listarCaracter(String texto);

		// listar normal
		@Query(nativeQuery = true, value = "SELECT * FROM PRODUCTORAS")
		public List<Productoras> listar();
}
