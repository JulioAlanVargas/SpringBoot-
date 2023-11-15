package com.mx.CrudInfraccion.dominio;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "AUTOS1")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Autos {
	/*CREATE TABLE AUTOS1(
		MATRICULA NVARCHAR2(50) PRIMARY KEY,
		MARCA NVARCHAR2(50),
		MODELO NVARCHAR2(50),
		COLOR NVARCHAR2(50),
		TIPO_AUTO NVARCHAR2(50),
		VALOR_AUTO NUMBER,
		CODIGO_PROPIETARIO NVARCHAR2(10),
		FOREIGN KEY(CODIGO_PROPIETARIO) REFERENCES PROPIETARIO1(CODIGO)
		);
	 */
	@Id
	String matricula;
	String marca;
	String modelo;
	String color;
	@Column(name = "TIPO_AUTO")
	String tipoAuto;
	@Column(name = "VALOR_AUTO")
	double valorAuto;

	// Cardinalidad ---- MUCHOS COCHES TIENE UN DUEÑO
	// fetch --- Indica que vamos a cargar la entidad
	// FetchType,EAGER --- La relacion debe ser cargada al momento
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODIGO_PROPIETARIO")
	Propietarios propietario;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipoAuto() {
		return tipoAuto;
	}

	public void setTipoAuto(String tipoAuto) {
		this.tipoAuto = tipoAuto;
	}

	public double getValorAuto() {
		return valorAuto;
	}

	public void setValorAuto(double valorAuto) {
		this.valorAuto = valorAuto;
	}

	public Propietarios getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietarios propietario) {
		this.propietario = propietario;
	}
	
	
}
