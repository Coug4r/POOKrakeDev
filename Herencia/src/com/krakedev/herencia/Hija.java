package com.krakedev.herencia;

public class Hija extends Padre{ 

	public Hija(int defectos, int virtudes, String nombre) {
		super(defectos, virtudes, nombre);
		// TODO Auto-generated constructor stub
	}

	public void escucharBadBunny() {
		System.out.println("Escuchando esta musica horrible");
	}

	@Override
	public String toString() {
		return "Hija Defectos: " + getDefectos() +" Virtudes: " +getVirtudes()+" Total ahorrado: "+getTotalAhorrado()+" Nombre: "+getNombre();
	}
	
	
	
}
