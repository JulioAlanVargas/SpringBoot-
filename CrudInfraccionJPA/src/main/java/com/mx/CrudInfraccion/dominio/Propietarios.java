package com.mx.CrudInfraccion.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PROPIETARIO1")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Propietarios {
	/*
	 * CREATE TABLE PROPIETARIO1( CODIGO NVARCHAR2(10) PRIMARY KEY, NOMBRE
	 * NVARCHAR2(50), APP NVARCHAR2(50), DIRECCION NVARCHAR2(200), FECHA_INFRACCION
	 * DATE, TIPO_INFRACCION NVARCHAR2(100), COSTO_INFRACCION NUMBER,
	 * UBICACION_INFRACION NVARCHAR2(50) );
	 */
	@Id
	String codigo;
	String nombre;
	String app;
	String direccion;
	@JsonFormat(pattern = "dd/MM/YYYY HH:MM:SS", timezone = "America/Mexico_City")
	@Column(name = "FECHA_INFRACCION")
	Date fechaInfraccion;
	@Column(name = "TIPO_INFRACCION")
	String tipoInfraccion;
	@Column(name = "COSTO_INFRACCION")
	double costoInfraccion;
	@Column(name = "UBICACION_INFRACION")
	String ubicacionInfraccion;

	// Cardinalidad
	@OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
	List<Autos> lista = new ArrayList<>();

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaInfraccion() {
		return fechaInfraccion;
	}

	public void setFechaInfraccion(Date fechaInfraccion) {
		this.fechaInfraccion = fechaInfraccion;
	}

	public String getTipoInfraccion() {
		return tipoInfraccion;
	}

	public void setTipoInfraccion(String tipoInfraccion) {
		this.tipoInfraccion = tipoInfraccion;
	}

	public double getCostoInfraccion() {
		return costoInfraccion;
	}

	public void setCostoInfraccion(double costoInfraccion) {
		this.costoInfraccion = costoInfraccion;
	}

	public String getUbicacionInfraccion() {
		return ubicacionInfraccion;
	}

	public void setUbicacionInfraccion(String ubicacionInfraccion) {
		this.ubicacionInfraccion = ubicacionInfraccion;
	}
	
	
}
