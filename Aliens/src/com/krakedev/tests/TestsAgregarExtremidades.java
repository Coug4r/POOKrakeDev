package com.krakedev.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.Alien.Alien;

public class TestsAgregarExtremidades {
	// =========================
	// ✅ PRUEBAS VÁLIDAS
	// =========================

	@Test
	public void testAgregarBrazosValido() {
	    Alien alien = new Alien(10, "Verde");
	    boolean resultado = alien.agregarBrazos(5);
	    assertTrue(resultado);
	}

	@Test
	public void testAgregarPiernasValido() {
	    Alien alien = new Alien(10, "Azul");
	    boolean resultado = alien.agregarPiernas(4);
	    assertTrue(resultado);
	}

	// =========================
	// ❌ PRUEBAS INVÁLIDAS
	// =========================

	@Test
	public void testAgregarBrazosInvalido() {
	    Alien alien = new Alien(10, "Rojo");
	    // numeroPies inicia en 0 → 0 + 11 > 10 → false
	    boolean resultado = alien.agregarBrazos(11);
	    assertFalse(resultado);
	}

	@Test
	public void testAgregarPiernasInvalido() {
	    Alien alien = new Alien(10, "Negro");
	    // numeroBrazos inicia en 0 → 0 + 15 > 10 → false
	    boolean resultado = alien.agregarPiernas(15);
	    assertFalse(resultado);
	}

	// =========================
	// 🔀 PRUEBAS COMBINADAS
	// =========================

	@Test
	public void testCombinadoValidoLuegoInvalido() {
	    Alien alien = new Alien(10, "Gris");

	    boolean r1 = alien.agregarBrazos(5);   // válido
	    boolean r2 = alien.agregarBrazos(20);  // inválido

	    assertTrue(r1);
	    assertFalse(r2);
	}

	@Test
	public void testCombinadoPiernasYBrazos() {
	    Alien alien = new Alien(10, "Morado");

	    boolean r1 = alien.agregarPiernas(3);  // válido
	    boolean r2 = alien.agregarBrazos(8);   // válido
	    boolean r3 = alien.agregarPiernas(20); // inválido

	    assertTrue(r1);
	    assertTrue(r2);
	    assertFalse(r3);
	}

	// =========================
	// 🔍 CASOS BORDE
	// =========================

	@Test
	public void testLimiteExactoBrazos() {
	    Alien alien = new Alien(10, "Blanco");
	    boolean resultado = alien.agregarBrazos(10); // 0 + 10 = 10 → válido
	    assertTrue(resultado);
	}

	@Test
	public void testLimiteExactoPiernas() {
	    Alien alien = new Alien(10, "Amarillo");
	    boolean resultado = alien.agregarPiernas(10); // 0 + 10 = 10 → válido
	    assertTrue(resultado);
	}
}
