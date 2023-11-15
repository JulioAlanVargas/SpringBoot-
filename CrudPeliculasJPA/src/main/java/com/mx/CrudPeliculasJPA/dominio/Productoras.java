package com.mx.CrudPeliculasJPA.dominio;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCTORAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productoras {
	/*CREATE TABLE PRODUCTORAS(
	ID NUMBER PRIMARY KEY,
	NOMBRE_PRODUCTORA NVARCHAR2(60),
	PAIS NVARCHAR2(60),
	ANIOS_MERCADO NUMBER,
	DIRECCION NVARCHAR2(200),
	CANTIDAD_PELICUAS NUMBER,
	CONTACTO NUMBER
	);*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "NOMBRE_PRODUCTORA")
	String nombreProductora;
	String pais;
	@Column(name = "ANIOS_MERCADO")
	String aniosMercado;
	String direccion;
	@Column(name = "CANTIDAD_PELICUAS")
	int cantidadPeliculas;
	long contacto;
	// Cardinalidad
	@OneToMany(mappedBy = "productora", cascade = CascadeType.ALL)
	List<Peliculas> lista = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreProductora() {
		return nombreProductora;
	}
	public void setNombreProductora(String nombreProductora) {
		this.nombreProductora = nombreProductora;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getAniosMercado() {
		return aniosMercado;
	}
	public void setAniosMercado(String aniosMercado) {
		this.aniosMercado = aniosMercado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public 	int getCantidadPeliculas() {
		return cantidadPeliculas;
	}
	public void setCantidadPeliculas(	int cantidadPeliculas) {
		this.cantidadPeliculas = cantidadPeliculas;
	}
	public long getContacto() {
		return contacto;
	}
	public void setContacto(long contacto) {
		this.contacto = contacto;
	}

}
