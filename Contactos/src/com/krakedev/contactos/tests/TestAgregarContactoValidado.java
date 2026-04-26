package com.krakedev.contactos.tests;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestAgregarContactoValidado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directorio dir = new Directorio();
		Contacto c1 = new Contacto();
		c1.setCelular("12314");
		Contacto c2 = new Contacto();
		c2.setCelular("12314");
		Contacto c3 = new Contacto();
		c3.setCelular("12314");
		boolean r1 = dir.agregarContacto(c1);
		boolean r2 = dir.agregarContacto(c1);
		
		System.out.println(r1);
		System.out.println(r2);
		
	}

}
