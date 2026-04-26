package com.krakedev.contactos.tests;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestRecuperarNumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Directorio dir = new Directorio();
		Contacto c1 = new Contacto();
		c1.setCelular("12314");
		Contacto c2 = new Contacto();
		c2.setCelular("12314");
		Contacto c3 = new Contacto();
		c3.setCelular("12314");
		dir.agregarContacto(c1);
		dir.agregarContacto(c2);
		dir.agregarContacto(c3);
		
		dir.cantidadContactos();
		
		dir.imprimirContactos();
		
		String num = dir.recuperarNumero(0);
		String num2 = dir.recuperarNumero(1);
		String num3 = dir.recuperarNumero(2);
		System.out.println(num);
		System.out.println(num2);
		System.out.println(num3);
	}

}
