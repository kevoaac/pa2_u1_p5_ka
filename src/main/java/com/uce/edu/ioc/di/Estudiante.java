package com.uce.edu.ioc.di;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component // Inversion de Control
public class Estudiante {
	
	private String cedula; 
	// Si no hago calculos con un dato no es correcto utilizarlo como un valor numerico.
	private String nombre;
	private String apellido;
	private BigDecimal salario; 
	// BigDecimal: Clase que se debe usar cuando se usa valores monetarios
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", salario=" + salario
				+ "]";
	}
	
	
	
	
}
