package com.krakedev.contactos.tests;

import com.krakedev.contacto.entidades.Contacto;

public class testContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacto c1 = new Contacto();
		System.out.println("NOmbre: "+c1.getNombre());
		System.out.println("Apellido: "+c1.getApellido());
		System.out.println("Edad: "+c1.getEdad());
		System.out.println("Celular: "+c1.getCelular());
		System.out.println("Peso: "+c1.getPeso());
		
	}

}
