package com.krakedev.financiero.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestRetiro {

	    @Test
	    void testRetiroValidoDisminuyeSaldo() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("1123094122","Mario", "987654321");
	        Cuenta cuenta = banco.crearCuenta(cliente);
	        cuenta.setSaldoActual(200.0);

	        boolean resultado = banco.retirar(50.0, cuenta);

	        assertTrue(resultado, "El retiro válido debe retornar true");
	        assertEquals(150.0, cuenta.getSaldoActual(),
	            "El saldo debe disminuir en 50");
	    }

	    @Test
	    void testRetiroMayorQueSaldoRechazado() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("1123094122","Mario", "987654321");
	        Cuenta cuenta = banco.crearCuenta(cliente);
	        cuenta.setSaldoActual(100.0);

	        boolean resultado = banco.retirar(200.0, cuenta);

	        assertFalse(resultado, "El retiro mayor al saldo debe retornar false");
	        assertEquals(100.0, cuenta.getSaldoActual(),
	            "El saldo no debe cambiar si el retiro excede el saldo");
	    }

	    @Test
	    void testRetiroNegativoRechazado() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("1123094122","Mario", "987654321");
	        Cuenta cuenta = banco.crearCuenta(cliente);
	        cuenta.setSaldoActual(300.0);

	        boolean resultado = banco.retirar(-50.0, cuenta);

	        assertFalse(resultado, "El retiro negativo debe retornar false");
	        assertEquals(300.0, cuenta.getSaldoActual(),
	            "El saldo no debe cambiar con retiro negativo");
	    }

	    @Test
	    void testRetiroCeroRechazado() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("1123094122","Mario", "987654321");
	        Cuenta cuenta = banco.crearCuenta(cliente);
	        cuenta.setSaldoActual(400.0);

	        boolean resultado = banco.retirar(0.0, cuenta);

	        assertFalse(resultado, "El retiro de cero debe retornar false");
	        assertEquals(400.0, cuenta.getSaldoActual(),
	            "El saldo no debe cambiar con retiro cero");
	    }

	    @Test
	    void testMultiplesRetirosValidos() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("1123094122","Mario", "987654321");
	        Cuenta cuenta = banco.crearCuenta(cliente);
	        cuenta.setSaldoActual(500.0);

	        banco.retirar(100.0, cuenta);
	        banco.retirar(50.0, cuenta);
	        banco.retirar(200.0, cuenta);

	        assertEquals(150.0, cuenta.getSaldoActual(),
	            "El saldo debe reflejar la suma de todos los retiros válidos");
	    }
}