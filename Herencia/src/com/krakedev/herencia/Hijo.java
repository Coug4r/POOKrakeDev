package com.krakedev.herencia;

public class Hijo extends Padre{
	private int juguetes;

	public Hijo(int juguetes, int virtudes, int defectos, String nombre) {
		super(defectos,virtudes,nombre);
		this.juguetes = juguetes;
	}

	@Override
	public String toString() {
		return "Hijo juguetes: " + juguetes + ", Defectos: " + getDefectos() + ", Virtudes: " + getVirtudes()+" Total Ahorrado: "+getTotalAhorrado()+" Nombre: "+getNombre();
	}
	
	@Override 
	public void ahorrar(double monto){
		super.ahorrar(monto * 0.5);
	}
}
