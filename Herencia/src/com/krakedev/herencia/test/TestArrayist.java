package com.krakedev.herencia.test;

import java.util.ArrayList;

import com.krakedev.herencia.Hija;

public class TestArrayist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Hija> listaDeHijas = new ArrayList<Hija>();
		Hija hij1 = new Hija();
		hij1.setDefectos(2);
		hij1.setVirtudes(4);
		
		listaDeHijas.add(hij1);
		
		Hija hij2 = new Hija();
		hij2.setDefectos(6);
		hij2.setVirtudes(1);
		
		listaDeHijas.add(hij2);
		
		Hija hij3 = new Hija();
		hij3.setDefectos(2);
		hij3.setVirtudes(4);
		
		listaDeHijas.add(hij3);
		
		System.out.println(listaDeHijas);
	}

}
