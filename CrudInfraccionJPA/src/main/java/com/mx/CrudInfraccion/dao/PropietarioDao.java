package com.mx.CrudInfraccion.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.CrudInfraccion.dominio.Propietarios;

import jakarta.transaction.Transactional;

@Repository
public interface PropietarioDao extends JpaRepository<Propietarios, Integer> {

	// guardar -> save()
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "INSERT INTO PROPIETARIO1 VALUES(:CODIGO,:NOMBRE,:APP,:DIRECCION,:FECHA_INFRACCION,:TIPO_INFRACCION,:COSTO_INFRACCION,:UBICACION_INFRACION)")
	void guardar(@Param("CODIGO") String codigo, @Param("NOMBRE") String nombre, @Param("APP") String app,
			@Param("DIRECCION") String direccion, @Param("FECHA_INFRACCION") Date fechaInfraccion,
			@Param("TIPO_INFRACCION") String tipoInfraccion, @Param("COSTO_INFRACCION") double costoInfraccion,
			@Param("UBICACION_INFRACION") String ubicacionInfraccion);

	//editar
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE PROPIETARIO1 SET NOMBRE = :NOMBRE, APP = :APP, DIRECCION = :DIRECCION, FECHA_INFRACCION = :FECHA_INFRACCION, TIPO_INFRACCION = :TIPO_INFRACCION, COSTO_INFRACCION = :COSTO_INFRACCION, UBICACION_INFRACION = :UBICACION_INFRACION WHERE CODIGO = :CODIGO")
	void editar(@Param("CODIGO") String codigo, @Param("NOMBRE") String nombre, @Param("APP") String app,
			@Param("DIRECCION") String direccion, @Param("FECHA_INFRACCION") Date fechaInfraccion,
			@Param("TIPO_INFRACCION") String tipoInfraccion, @Param("COSTO_INFRACCION") double costoInfraccion,
			@Param("UBICACION_INFRACION") String ubicacionInfraccion);
	
	
	// buscar por nombre
	@Query(nativeQuery = true, value = "SELECT * FROM PROPIETARIO1 WHERE NOMBRE=:NOMBRE")
	public Propietarios buscarXNombre(@Param("NOMBRE") String nombre);

	// buscar por ubicacion
	@Query(nativeQuery = true, value = "SELECT * FROM PROPIETARIO1 WHERE UBICACION_INFRACION=:UBICACION_INFRACION")
	public Propietarios buscarXUbicacion(@Param("UBICACION_INFRACION") String ubicacionInfraccion);

	// eliminar por codigo
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM PROPIETARIO1 WHERE CODIGO=:CODIGO")
	void eliminarCodigo(@Param("CODIGO") String codigo);

	// eliminar por nombre
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM PROPIETARIO1 WHERE NOMBRE=:NOMBRE")
	void eliminarNombre(@Param("NOMBRE") String nombre);

	// listar por direccion
	@Query(nativeQuery = true, value = "SELECT * FROM PROPIETARIO1 WHERE DIRECCION=:DIRECCION")
	public List<Propietarios> listarDireccion(@Param("DIRECCION") String direccion);

	// listar por app
	@Query(nativeQuery = true, value = "SELECT * FROM PROPIETARIO1 WHERE APP=:APP")
	public List<Propietarios> listarApp(@Param("APP") String app);

	// listar por Atributo
	@Query(nativeQuery = true, value = "SELECT * FROM PROPIETARIO1 WHERE UBICACION_INFRACION LIKE %?1% OR TIPO_INFRACCION LIKE %?1%")
	List<Propietarios> listarAtributo(String texto);

	// listar normal
	@Query(nativeQuery = true, value = "SELECT * FROM PROPIETARIO1")
	public List<Propietarios> listar();
}
