package com.krakedev.contactos.tests;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestImprimirContacto {
	public static void main(String args[]) {
		Directorio dir = new Directorio();
		Contacto c1 = new Contacto();
		c1.setNombre("Maria");
		Contacto c2 = new Contacto();
		c2.setNombre("Lupe");
		Contacto c3 = new Contacto();
		c3.setNombre("Constansa");
		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		
		dir.cantidadContactos();
		
		dir.imprimirContactos();
	}
}
