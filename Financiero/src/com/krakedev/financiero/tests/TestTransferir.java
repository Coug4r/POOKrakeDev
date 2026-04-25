package com.krakedev.financiero.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestTransferir {
	
	    @Test
	    void testTransferenciaValida() {
	        Banco banco = new Banco();
	        Cliente cliente1 = new Cliente("1234567890", "Andres", "Perez");
	        Cliente cliente2 = new Cliente("0987654321", "Mario", "Lopez");

	        Cuenta origen = banco.crearCuenta(cliente1);
	        Cuenta destino = banco.crearCuenta(cliente2);

	        origen.setSaldoActual(500.0);
	        destino.setSaldoActual(200.0);

	        boolean resultado = banco.transferir(origen, destino, 100.0);

	        assertTrue(resultado, "La transferencia válida debe retornar true");
	        assertEquals(400.0, origen.getSaldoActual(),
	            "El saldo de origen debe disminuir en 100");
	        assertEquals(300.0, destino.getSaldoActual(),
	            "El saldo de destino debe aumentar en 100");
	    }

	    @Test
	    void testTransferenciaSaldoInsuficiente() {
	        Banco banco = new Banco();
	        Cliente cliente1 = new Cliente("1112223334", "Ana", "Gomez");
	        Cliente cliente2 = new Cliente("5556667778", "Luis", "Martinez");

	        Cuenta origen = banco.crearCuenta(cliente1);
	        Cuenta destino = banco.crearCuenta(cliente2);

	        origen.setSaldoActual(50.0);
	        destino.setSaldoActual(200.0);

	        boolean resultado = banco.transferir(origen, destino, 100.0);

	        assertFalse(resultado, "La transferencia con saldo insuficiente debe retornar false");
	        assertEquals(50.0, origen.getSaldoActual(),
	            "El saldo de origen no debe cambiar");
	        assertEquals(200.0, destino.getSaldoActual(),
	            "El saldo de destino no debe cambiar");
	    }

	    @Test
	    void testTransferenciaMontoExacto() {
	        Banco banco = new Banco();
	        Cliente cliente1 = new Cliente("9998887776", "Carla", "Suarez");
	        Cliente cliente2 = new Cliente("4443332221", "Pedro", "Ramirez");

	        Cuenta origen = banco.crearCuenta(cliente1);
	        Cuenta destino = banco.crearCuenta(cliente2);

	        origen.setSaldoActual(300.0);
	        destino.setSaldoActual(100.0);

	        boolean resultado = banco.transferir(origen, destino, 300.0);

	        assertTrue(resultado, "La transferencia con monto exacto debe retornar true");
	        assertEquals(0.0, origen.getSaldoActual(),
	            "El saldo de origen debe quedar en 0");
	        assertEquals(400.0, destino.getSaldoActual(),
	            "El saldo de destino debe aumentar correctamente");
	    }

	    @Test
	    void testMultiplesTransferencias() {
	        Banco banco = new Banco();
	        Cliente cliente1 = new Cliente("2223334445", "Sofia", "Torres");
	        Cliente cliente2 = new Cliente("7778889990", "Diego", "Castillo");

	        Cuenta origen = banco.crearCuenta(cliente1);
	        Cuenta destino = banco.crearCuenta(cliente2);

	        origen.setSaldoActual(1000.0);
	        destino.setSaldoActual(500.0);

	        banco.transferir(origen, destino, 200.0);
	        banco.transferir(origen, destino, 300.0);
	        banco.transferir(origen, destino, 100.0);

	        assertEquals(400.0, origen.getSaldoActual(),
	            "El saldo de origen debe reflejar todas las transferencias");
	        assertEquals(1100.0, destino.getSaldoActual(),
	            "El saldo de destino debe reflejar todas las transferencias");
	    }
}
