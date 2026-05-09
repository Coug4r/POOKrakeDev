package com.krakedev.herencia;

public class Padre {
	private int defectos;
	private int virtudes;
	private double totalAhorrado;
	private String nombre;
	

	public Padre(int defectos, int virtudes, String nombre) {
		super();
		this.defectos = defectos;
		this.virtudes = virtudes;
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Padre Defectos: " + defectos + ", Virtudes:" + virtudes + ", TotalAhorrado: " + totalAhorrado
				+ ", Nombre:" + nombre;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTotalAhorrado() {
		return totalAhorrado;
	}

	public void setTotalAhorrado(double totalAhorrado) {
		this.totalAhorrado = totalAhorrado;
	}

	public int getDefectos() {
		return defectos;
	}
	public void setDefectos(int defectos) {
		this.defectos = defectos;
	}
	public int getVirtudes() {
		return virtudes;
	}
	public void setVirtudes(int virtudes) {
		this.virtudes = virtudes;
	}
	
	public void imprimir() {
		System.out.println("Virtudes: "+ virtudes);
		System.out.println("Defectos: "+ defectos);
	}
	
	private void guardaSecreto() {
		System.out.println("No se hereda");
	}
	public void ahorrar(double monto){
		totalAhorrado += monto;
	}
}
