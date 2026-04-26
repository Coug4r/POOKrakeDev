//package com.krakedev.contactos.tests;
//
//import com.krakedev.contacto.entidades.Contacto;
//import com.krakedev.contacto.entidades.Directorio;
//
//public class TestReferenciaErrores {
//
//	public static void main(String[] args) {
//		Directorio dir = new Directorio();
//		Contacto c1 = new Contacto();
//		c1.setNombre("Maria");
//		
//		dir.agregarContacto(c1);
//		
//		dir.agregarContacto(new Contacto());
//		
//		Contacto c = dir.obtenerContacto(2);
//		System.out.println(c.getNombre());
//	}
//
//}
