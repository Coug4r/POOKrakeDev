package com.krakedev.financiero.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestDepositar {

	    @Test
	    void testDepositoPositivoIncrementaSaldo() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("11021822266","Andres", "123456789");
	        Cuenta cuenta = banco.crearCuenta(cliente);
	        cuenta.setSaldoActual(100.0);

	        boolean resultado = banco.depositar(50.0, cuenta);

	        assertTrue(resultado, "El depósito positivo debe retornar true");
	        assertEquals(150.0, cuenta.getSaldoActual(),
	            "El saldo debe incrementarse en 50");
	    }

	    @Test
	    void testDepositoCeroNoModificaSaldo() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("1123094122","Mario", "987654321");
	        Cuenta cuenta = banco.crearCuenta(cliente);
	        cuenta.setSaldoActual(200.0);

	        boolean resultado = banco.depositar(0.0, cuenta);

	        assertFalse(resultado, "El depósito de cero debe retornar false");
	        assertEquals(200.0, cuenta.getSaldoActual(),
	            "El saldo no debe cambiar con depósito cero");
	    }

	    @Test
	    void testDepositoNegativoNoModificaSaldo() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("1341221421","Luis", "456789123");
	        Cuenta cuenta = banco.crearCuenta(cliente);
	        cuenta.setSaldoActual(300.0);

	        boolean resultado = banco.depositar(-100.0, cuenta);

	        assertFalse(resultado, "El depósito negativo debe retornar false");
	        assertEquals(300.0, cuenta.getSaldoActual(),
	            "El saldo no debe cambiar con depósito negativo");
	    }

	    @Test
	    void testMultiplesDepositosPositivos() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("12141212","Ana", "111222333");
	        Cuenta cuenta = banco.crearCuenta(cliente);
	        cuenta.setSaldoActual(0.0);

	        banco.depositar(100.0, cuenta);
	        banco.depositar(200.0, cuenta);
	        banco.depositar(50.0, cuenta);

	        assertEquals(350.0, cuenta.getSaldoActual(),
	            "El saldo debe reflejar la suma de todos los depósitos");
	    }
	}
