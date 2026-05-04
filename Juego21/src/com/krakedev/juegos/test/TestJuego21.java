package com.krakedev.juegos.test;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {
    public static void main(String[] args) {
        Juego21 juego = new Juego21();

        Jugador j1 = new Jugador("David");
        Jugador j2 = new Jugador("Ana");
        Jugador j3 = new Jugador("Luis");

        juego.agregarJugador(j1);
        juego.agregarJugador(j2);
        juego.agregarJugador(j3);

        juego.inicializar();

        juego.repartirRonda();

        j1.imprimir();
        j2.imprimir();
        j3.imprimir();


        System.out.println("Cartas restantes en el mazo: " + juego.getDealer().getNaipe().size());
        System.out.println("Mazo actual:");
        juego.getDealer().imprimirNaipe();
    }
}