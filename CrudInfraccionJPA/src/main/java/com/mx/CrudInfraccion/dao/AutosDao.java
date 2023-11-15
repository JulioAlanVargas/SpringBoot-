package com.mx.CrudInfraccion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.CrudInfraccion.dominio.Autos;
import com.mx.CrudInfraccion.dominio.Propietarios;

import jakarta.transaction.Transactional;

@Repository
public interface AutosDao extends JpaRepository<Autos, Integer> {

	// guardar
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "INSERT INTO AUTOS1 VALUES(:MATRICULA,:MARCA,:MODELO,:COLOR,:TIPO_AUTO,:VALOR_AUTO,:CODIGO_PROPIETARIO)")
	void guardar(@Param("MATRICULA") String matricula, @Param("MARCA") String marca, @Param("MODELO") String modelo,
			@Param("COLOR") String color, @Param("TIPO_AUTO") String tipoAuto, @Param("VALOR_AUTO") double valorAuto,
			@Param("CODIGO_PROPIETARIO") String codigo);

	// buscar por marca
	@Query(nativeQuery = true, value = "SELECT * FROM AUTOS1 WHERE MARCA=:MARCA")
	Autos buscarXMarca(@Param("MARCA") String marca);

	// buscar por modelo
	@Query(nativeQuery = true, value = "SELECT * FROM AUTOS1 WHERE MODELO=:MODELO")
	Autos buscarXModelo(@Param("MODELO") String modelo);

	// buscar por Tipo o Color
	@Query(nativeQuery = true, value = "SELECT * FROM AUTOS1 WHERE TIPO_AUTO = :TIPO_AUTO OR COLOR = :COLOR")
	Autos buscarPorTipoOColor(@Param("TIPO_AUTO") String tipoAuto, @Param("COLOR") String color);

	// eliminar por matricula
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM AUTOS1 WHERE MATRICULA=:MATRICULA")
	void eliminarMatricula(@Param("MATRICULA") String matricula);

	// eliminar por marca
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM AUTOS1 WHERE MARCA=:MARCA")
	void eliminarMarca(@Param("MARCA") String marca);

	// listar por marca
	@Query(nativeQuery = true, value = "SELECT * FROM AUTOS1 WHERE MARCA=:MARCA")
	List<Autos> listarMarca(@Param("MARCA") String marca);

	// listar por modelo
	@Query(nativeQuery = true, value = "SELECT * FROM AUTOS1 WHERE MODELO=:MODELO")
	List<Autos> listarModelo(@Param("MODELO") String modelo);

	// listar por Atributo
	@Query(nativeQuery = true, value = "SELECT * FROM AUTOS1 WHERE MARCA LIKE %?1% OR MODELO LIKE %?1%")
	List<Autos> listarAtributo(String texto);

	// listar normal
	@Query(nativeQuery = true, value = "SELECT * FROM AUTOS1")
	List<Autos> listar();

	// buscar inner join
	@Query(nativeQuery = true, value = "SELECT * FROM PROPIETARIO1 INNER JOIN AUTOS1 ON PROPIETARIO1.CODIGO = AUTOS1.CODIGO_PROPIETARIO WHERE CODIGO=:CODIGO")
	List<Autos> listarPropietario(@Param("CODIGO") String codigo);
}
