package com.krakedev.tests;

import com.krakedev.Alien.Alien;

public class TestConstructores {
	public static void main(String args[]) {
		Alien alien1 = new Alien(10, "Verde");
		Alien alien2 = new Alien(31, "Negro");
		System.out.println("**********Alien 1 **********");
		alien1.imprimir();
		System.out.println("**********Alien 2**********");
		alien2.imprimir();
	}
}
