package com.krakedev.herencia.test;

import com.krakedev.herencia.Hija;
import com.krakedev.herencia.Hijo;
import com.krakedev.herencia.Padre;

public class TestAhorros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Padre p1 = new Padre(5, 10, "Juan");
		p1.ahorrar(200);
		Hija h1 = new Hija(4,0, "Pedro");
		h1.ahorrar(200);
		Hijo h2 = new Hijo(10,3,1,"Camila");
		h2.ahorrar(200);
		
		System.out.println(p1);
		System.out.println(h1);
		System.out.println(h2);
	}

}
