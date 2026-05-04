package com.krakedev.juegos.test;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Jugador;
import com.krakedev.juegos.servicios.Juego21;

public class TestJuego21 {
    public static void main(String[] args) {

        System.out.println("=== PRIMERA PRUEBA ===");
        Juego21 juego1 = new Juego21();
        juego1.inicializar();

        juego1.agregarJugador(new Jugador("David"));
        juego1.agregarJugador(new Jugador("Ana"));
        juego1.agregarJugador(new Jugador("Luis"));

        ArrayList<Jugador> ganadores1 = juego1.jugar();

        for (Jugador jugador : juego1.getJugadores()) {
            jugador.imprimir();
        }

        if (ganadores1.isEmpty()) {
            System.out.println("No hubo ganadores con 21 puntos en esta partida.");
        } else {
            System.out.println("Ganadores:");
            for (Jugador g : ganadores1) {
                System.out.println("Jugador: " + g.getNickname() + " con puntaje " + g.getPuntajeCartas());
            }
        }

        // ============================
        // SEGUNDA PRUEBA: ejecutar varias veces hasta que existan ganadores
        // ============================
        System.out.println("\n=== SEGUNDA PRUEBA ===");
        boolean huboGanador = false;

        for (int intento = 1; intento <= 10; intento++) {
            System.out.println(">>> Intento " + intento);

            // Reiniciar el juego (nuevo dealer y jugadores con puntaje 0 y sin cartas)
            Juego21 juego2 = new Juego21();
            juego2.inicializar();

            Jugador j1 = new Jugador("Carlos");
            Jugador j2 = new Jugador("Maria");
            Jugador j3 = new Jugador("Pedro");

            juego2.agregarJugador(j1);
            juego2.agregarJugador(j2);
            juego2.agregarJugador(j3);

            ArrayList<Jugador> ganadores2 = juego2.jugar();

            for (Jugador jugador : juego2.getJugadores()) {
                jugador.imprimir();
            }

            if (!ganadores2.isEmpty()) {
                System.out.println("¡Ganadores encontrados en el intento " + intento + "!");
                for (Jugador g : ganadores2) {
                    System.out.println("Jugador: " + g.getNickname() + " con puntaje " + g.getPuntajeCartas());
                }
                huboGanador = true;
                break; 
            } else {
                System.out.println("No hubo ganadores en este intento.");
            }
        }

        if (!huboGanador) {
            System.out.println("En 10 intentos no se encontró ningún ganador con 21 puntos.");
        }
    }
}