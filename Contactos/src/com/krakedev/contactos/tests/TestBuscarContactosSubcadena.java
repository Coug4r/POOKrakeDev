package com.krakedev.contactos.tests;

import java.util.ArrayList;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestBuscarContactosSubcadena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Directorio dir = new Directorio();
		Contacto c1 = new Contacto();
		c1.setNombre("Maria");
		c1.setCelular("1234");
		Contacto c2 = new Contacto();
		c2.setNombre("Mafer");
		c2.setCelular("2314");
		Contacto c3 = new Contacto();
		c3.setNombre("Constansa");
		c3.setCelular("43212");
		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		
		ArrayList<Contacto> encontrados = dir.buscarContactosCoincidencia("Ma");
		
		for(int i=0; i<encontrados.size();i++) {
			Contacto con = encontrados.get(i);
			System.out.println("Nombre: " + con.getNombre());
		}
	}

}
