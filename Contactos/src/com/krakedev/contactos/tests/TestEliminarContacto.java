package com.krakedev.contactos.tests;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestEliminarContacto {
	public static void main(String args[]) {
		Directorio dir = new Directorio();
		Contacto c1 = new Contacto();
		c1.setCelular("12314");
		Contacto c2 = new Contacto();
		c2.setCelular("12314");
		Contacto c3 = new Contacto();
		c3.setCelular("1234");
		
		dir.agregarContacto(c3);
		boolean r1 = dir.eliminarContacto("1234");
		
		System.out.println(r1);
		
	}
}	
