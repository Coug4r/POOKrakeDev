package com.krakedev.artesanal.testJUnit;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigo {
	
	@Test
	public void asignarCodigo() {
	    Negocio barDeMoe = new Negocio();
	    Cliente mario = new Cliente("Mario", "123456789");
	    Cliente andres = new Cliente("Andres", "123456789");
	    barDeMoe.asignarCodigoCliente(mario);
	    barDeMoe.asignarCodigoCliente(andres);
	}

}
