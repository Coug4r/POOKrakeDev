package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquina {

	    @Test
	    public void testRecuperarMaquinaExistente() {
	        NegocioMejorado negocio = new NegocioMejorado(new ArrayList<>());

	        // Usamos agregarMaquina para crear y añadir la máquina
	        negocio.agregarMaquina("Cerveza Club", "Fria", 0.2);

	        // Obtenemos el código generado automáticamente
	        String codigoBuscado = negocio.getMaquinas().get(0).getCodigo();

	        // Recuperamos la máquina por código
	        Maquina resultado = negocio.recuperarMaquina(codigoBuscado);

	        assertNotNull(resultado, "Debe devolver una máquina existente");
	        assertEquals(codigoBuscado, resultado.getCodigo());
	        assertEquals("Cerveza Club", resultado.getNombreCerveza());
	        assertEquals("Fria", resultado.getDescripcion());
	    }

	    @Test
	    public void testRecuperarMaquinaNoExistente() {
	        NegocioMejorado negocio = new NegocioMejorado(new ArrayList<>());

	        // Agregamos una máquina
	        negocio.agregarMaquina("Pilsener", "Rubia", 0.002);

	        // Intentamos recuperar con un código inexistente
	        Maquina resultado = negocio.recuperarMaquina("COD_NO_EXISTE");

	        assertNull(resultado, "Debe devolver null si el código no existe");
	    }
}
