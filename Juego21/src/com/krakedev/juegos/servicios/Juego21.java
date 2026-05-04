package com.krakedev.juegos.servicios;

import java.util.ArrayList;

import com.krakedev.juegos.entidades.Carta;
import com.krakedev.juegos.entidades.Dealer;
import com.krakedev.juegos.entidades.Jugador;

public class Juego21 {
    private ArrayList<Jugador> jugadores;
    private Dealer dealer;

    public Juego21() {
        this.jugadores = new ArrayList<>();
    }

    public void inicializar() {
        this.dealer = new Dealer();
        cargarValores();
    }


    private void cargarValores() {
        for (Carta carta : dealer.getNaipe()) {
            String valor = carta.getValor();
            switch (valor) {
                case "A":
                    carta.setValorJuego(11);
                    break;
                case "J":
                case "Q":
                case "K":
                    carta.setValorJuego(10);
                    break;
                default:
                    int numero = Integer.parseInt(valor);
                    carta.setValorJuego(numero);
                    break;
            }
        }
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void repartirCarta(Jugador jugador) {
        Carta carta = dealer.entregarCarta();
        if (carta != null) {
            jugador.recibirCarta(carta);
        }
    }

    public void repartirRonda() {
        for (Jugador jugador : jugadores) {
            repartirCarta(jugador);
        }
        calcularTotal(); 
    }

    public void calcularTotal() {
        for (Jugador jugador : jugadores) {
            int total = 0;
            for (Carta carta : jugador.getCartas()) {
                total += carta.getValorJuego();
            }
            jugador.setPuntajeCartas(total);
        }
    }

    public ArrayList<Jugador> validarGanador() {
        ArrayList<Jugador> ganadores = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntajeCartas() == 21) {
                ganadores.add(jugador);
            }
        }
        return ganadores;
    }

    public ArrayList<Jugador> jugar() {
        ArrayList<Jugador> ganadores = new ArrayList<>();

        for (int ronda = 1; ronda <= 3; ronda++) {
            System.out.println("=== Ronda " + ronda + " ===");
            repartirRonda();
            ganadores = validarGanador();

            if (!ganadores.isEmpty()) {
                System.out.println("¡Ganador encontrado en la ronda " + ronda + "!");
                break;
            }
        }

        return ganadores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public Dealer getDealer() {
        return dealer;
    }
}