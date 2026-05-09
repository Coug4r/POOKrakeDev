package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {
	public static void main(String args[]) {
		Maquina rubia = new Maquina("Pilsener", "cerveza rubia", 0.02,10000);
		rubia.imprimir();
		rubia.setNombreCerveza("Golden Ale");
		rubia.setDescripcion("Cerveza con aroma mas intenso");
		rubia.imprimir();
		System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.runtime.version"));
        System.out.println(System.getProperty("java.vendor"));
	}
}
