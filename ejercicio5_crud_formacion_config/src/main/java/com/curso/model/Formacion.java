package com.curso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Formacion {

	private String nombre;
	private int asignaturas;
	private double precio;
	@JsonProperty("duracion")
	private int duracion;
	public Formacion(String nombre, int asignaturas, double precio, int duracion) {
		super();
		this.nombre = nombre;
		this.asignaturas = asignaturas;
		this.precio = precio;
		this.duracion= duracion;	
	}
	public Formacion() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setTexto(String nombre) {
		this.nombre = nombre;
	}
	public int getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(int asignaturas) {
		this.asignaturas = asignaturas;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
}
