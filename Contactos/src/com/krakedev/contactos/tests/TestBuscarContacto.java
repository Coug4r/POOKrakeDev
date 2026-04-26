package com.krakedev.contactos.tests;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestBuscarContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directorio dir = new Directorio();
		Contacto c1 = new Contacto();
		c1.setCelular("12314");
		Contacto c2 = new Contacto();
		c2.setCelular("12314");
		Contacto c3 = new Contacto();
		c3.setCelular("1234");
		c3.setNombre("David");
		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		
		Contacto conRec = dir.buscarContacto("1234");
		if(conRec != null) {
			System.out.println(conRec.getNombre());
		}else {
			System.out.println("No existe");
		}
	}

}
