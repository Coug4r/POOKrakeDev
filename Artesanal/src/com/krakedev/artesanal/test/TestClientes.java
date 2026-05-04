package com.krakedev.artesanal.test;

import java.util.ArrayList;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {
	public static  void main(String args[]) {
		NegocioMejorado negocio = new NegocioMejorado(new ArrayList<>());
		negocio.registrarCliente("", "");
	}
}
