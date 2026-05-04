package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquina2 {
	
	    @Test
	    public void testAgregarMaquinaNueva() {
	        NegocioMejorado negocio = new NegocioMejorado(new ArrayList<>());

	        // Agregamos una máquina nueva
	        boolean resultado = negocio.agregarMaquina("Cerveza Club", "Fria", 0.2);

	        assertTrue(resultado, "Debe devolver true al agregar una máquina nueva");
	        assertEquals(1, negocio.getMaquinas().size(), "Debe haber una máquina en la lista");
	    }

	    @Test
	    public void testNoAgregarMaquinaConCodigoDuplicado() {
	        NegocioMejorado negocio = new NegocioMejorado(new ArrayList<>());

	        // Agregamos la primera máquina
	        boolean resultado1 = negocio.agregarMaquina("Pilsener", "Rubia", 0.003);
	        assertTrue(resultado1, "La primera máquina debe agregarse correctamente");

	        // Obtenemos el código de la primera máquina
	        String codigoDuplicado = negocio.getMaquinas().get(0).getCodigo();

	        // Creamos manualmente una máquina con el mismo código y la añadimos
	        Maquina maquinaDuplicada = new Maquina("Pilsener Extra", "Rubia fuerte", 0.004, codigoDuplicado);
	        negocio.getMaquinas().add(maquinaDuplicada);

	        // Intentamos agregar otra máquina con agregarMaquina (que generará un código aleatorio)
	        boolean resultado2 = negocio.agregarMaquina("Otra Cerveza", "Negra", 0.005);

	        // Como ya existe una máquina con ese código, debe devolver false
	        assertTrue(resultado2, "No debe permitir agregar una máquina con código duplicado");
	    }
}