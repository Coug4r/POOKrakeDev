package com.krakedev.contactos.testsJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.contacto.entidades.Contacto;
import com.krakedev.contacto.entidades.Directorio;

public class TestAgregarContacto {

	    @Test
	    void testAgregarContactoNuevo() {
	        Directorio directorio = new Directorio();
	        Contacto contacto = new Contacto();
	        contacto.setNombre("Ana");
	        contacto.setApellido("Perez");
	        contacto.setEdad(25);
	        contacto.setCelular("0999999999");
	        contacto.setPeso(55.0);

	        boolean resultado = directorio.agregarContacto(contacto);

	        assertTrue(resultado, "Debe retornar true al agregar un contacto nuevo");
	        assertEquals(1, directorio.cantidadContactos(),
	            "La cantidad de contactos debe ser 1");
	        assertEquals("Ana", directorio.obtenerContacto(0).getNombre(),
	            "El nombre del contacto agregado debe ser Ana");
	    }

	    @Test
	    void testAgregarContactoDuplicado() {
	        Directorio directorio = new Directorio();

	        Contacto contacto1 = new Contacto();
	        contacto1.setNombre("Luis");
	        contacto1.setApellido("Lopez");
	        contacto1.setEdad(30);
	        contacto1.setCelular("0888888888");
	        contacto1.setPeso(70.0);

	        Contacto contacto2 = new Contacto();
	        contacto2.setNombre("Mario");
	        contacto2.setApellido("Gomez");
	        contacto2.setEdad(28);
	        contacto2.setCelular("0888888888"); // mismo celular
	        contacto2.setPeso(68.0);

	        boolean resultado1 = directorio.agregarContacto(contacto1);
	        boolean resultado2 = directorio.agregarContacto(contacto2);

	        assertTrue(resultado1, "El primer contacto debe agregarse correctamente");
	        assertFalse(resultado2, "El segundo contacto con celular duplicado debe ser rechazado");
	        assertEquals(1, directorio.cantidadContactos(),
	            "La cantidad de contactos debe seguir siendo 1");
	    }

	    @Test
	    void testRecuperarNumero() {
	        Directorio directorio = new Directorio();
	        Contacto contacto = new Contacto();
	        contacto.setNombre("Carla");
	        contacto.setApellido("Suarez");
	        contacto.setEdad(22);
	        contacto.setCelular("0777777777");
	        contacto.setPeso(60.0);

	        directorio.agregarContacto(contacto);

	        String numero = directorio.recuperarNumero(0);

	        assertEquals("0777777777", numero,
	            "El número recuperado debe coincidir con el celular del contacto");
	    }
}
