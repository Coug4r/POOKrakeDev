package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestVaciarMaquina {

    @Test
    public void testVaciarMaquina() {
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.002, 5000);
        System.out.println("Cantidad antes de recargar: " + maquina.getCantidadActual());
        maquina.recargarCerveza(2000); // agregamos cerveza
        assertEquals(2000, maquina.getCantidadActual());
        System.out.println("Cantidad despues de recargar: " + maquina.getCantidadActual());
        maquina.vaciarMquina(); // vaciamos la máquina
        System.out.println("Cantidad despues de vaciar: " + maquina.getCantidadActual() + "Cantidad desperdiciada: "+maquina.getCantidadDesperdicio());
        assertEquals(0, maquina.getCantidadActual());
        assertEquals(2000, maquina.getCantidadDesperdicio());
    }

    @Test
    public void testRecargarCerveza() {
        Maquina maquina = new Maquina("Club", "Negra", 0.003, 5000);
        System.out.println("Cantidad antes de recargar: " + maquina.getCantidadActual()+" limite: " +maquina.getCapacidadMaxima());
        boolean resultado = maquina.recargarCerveza(3000);
        System.out.println("Cantidad despues de recargar: " + maquina.getCantidadActual());
        assertTrue(resultado);
        assertEquals(3000, maquina.getCantidadActual());

        // Intentar sobrepasar el límite
        boolean resultado2 = maquina.recargarCerveza(3000);
        System.out.println("Intento de sobrepasar limite: " + resultado);
        assertFalse(resultado2);
        assertEquals(3000, maquina.getCantidadActual()); // no debe cambiar
    }

    @Test
    public void testServirCerveza() {
        Maquina maquina = new Maquina("Corona", "Clara", 0.005, 5000);
        maquina.recargarCerveza(2000);
        System.out.println("Cantidad antes de servir: " + maquina.getCantidadActual());
        double valor = maquina.servirCerveza(500); // servir 500 ml
        System.out.println("Precio del servicio: " + valor);
        assertEquals(500 * 0.005, valor);
        assertEquals(1500, maquina.getCantidadActual());

        // Intentar servir más de lo disponible
        System.out.println("Cantidad antes de servir: " + maquina.getCantidadActual());
        double valor2 = maquina.servirCerveza(3000);
        System.out.println("Precio del servicio(Sin producto suficiente): " + valor);
        assertEquals(0.0, valor2);
        assertEquals(1500, maquina.getCantidadActual()); // no debe cambiar
    }
}
