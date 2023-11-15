package com.mx.CrudPeliculasJPA.dominio;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PELICULAS_P")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Peliculas {
	/*CREATE TABLE PELICULAS_P(
    ID NUMBER PRIMARY KEY,
    TITULO NVARCHAR2(50),
    FECHA_ESTRENO DATE,
    PRODUCTORA NVARCHAR2(50),
    DIRECTOR  NVARCHAR2(50),
    GENERO  NVARCHAR2(50),
    DURACION NVARCHAR2(50),
    PRECIO NUMBER,
    ID_PRODUCTORA NUMBER,
FOREIGN KEY(ID_PRODUCTORA) REFERENCES PRODUCTORAS(ID)
);*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String titulo;
	@JsonFormat(pattern = "dd/mm/yyyy", timezone = "America/Mexico_City")
	@Column(name = "FECHA_ESTRENO")
	Date fechaEstreno;
	String productora;
	String director;
	String genero;
	String duracion;
	double precio;
	// Cardinalidad ---- MUCHOS COCHES TIENE UN DUEÑO
	// fetch --- Indica que vamos a cargar la entidad
	// FetchType,EAGER --- La relacion debe ser cargada al momento
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PRODUCTORA")
	Productoras productoras;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getProductora() {
		return productora;
	}
	public void setProductora(String productora) {
		this.productora = productora;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Productoras getProductoras() {
		return productoras;
	}
	public void setProductoras(Productoras productoras) {
		this.productoras = productoras;
	}

	
}
