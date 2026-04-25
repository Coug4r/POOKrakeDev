package com.krakedev.financiero.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestCrearCuenta {
	
	    @Test
	    void testCrearCuentaGeneraCodigoInicial() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("11021822266","Andres", "123456789");

	        Cuenta cuenta = banco.crearCuenta(cliente);

	        assertEquals("1000", cuenta.getId(), 
	            "El primer código debe ser 1000");
	        assertEquals(1001, banco.getUltimoCodigo(), 
	            "Después de crear la cuenta, ultimoCodigo debe incrementarse");
	    }

	    @Test
	    void testCrearCuentaGeneraCodigosConsecutivos() {
	        Banco banco = new Banco();
	        Cliente cliente1 = new Cliente("1123094122","Mario", "987654321");
	        Cliente cliente2 = new Cliente("1341221421","Luis", "456789123");

	        Cuenta cuenta1 = banco.crearCuenta(cliente1);
	        Cuenta cuenta2 = banco.crearCuenta(cliente2);

	        assertEquals("1000", cuenta1.getId(), 
	            "La primera cuenta debe tener código 1000");
	        assertEquals("1001", cuenta2.getId(), 
	            "La segunda cuenta debe tener código 1001");
	        assertEquals(1002, banco.getUltimoCodigo(), 
	            "ultimoCodigo debe avanzar a 1002 después de dos cuentas");
	    }

	    @Test
	    void testCrearMultiplesCuentas() {
	        Banco banco = new Banco();
	        Cliente cliente = new Cliente("12141212","Ana", "111222333");

	        for (int i = 0; i < 5; i++) {
	            Cuenta cuenta = banco.crearCuenta(cliente);
	            assertEquals(String.valueOf(1000 + i), cuenta.getId(),
	                "El código debe ser consecutivo empezando en 1000");
	        }

	        assertEquals(1005, banco.getUltimoCodigo(),
	            "ultimoCodigo debe ser 1005 después de 5 cuentas");
	    }
	}