package com.krakedev.juegos.entidades;

import java.util.ArrayList;
import java.util.Random;

public class Dealer {
    private ArrayList<Carta> naipe;

    public Dealer() {
        this.naipe = new ArrayList<Carta>();
        generarNaipe();
    }

    public ArrayList<Carta> getNaipe() {
        return naipe;
    }

    public void setNaipe(ArrayList<Carta> naipe) {
        this.naipe = naipe;
    }

    public void generarNaipe() {
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] palos = {"T","CN","D","CR"};

        for (String palo : palos) {
            for (String valor : valores) {
                Carta carta = new Carta(valor, palo);
                naipe.add(carta);
            }
        }
    }

    public void imprimirNaipe() {
        for (Carta carta : naipe) {
            carta.imprimir();
            System.out.println("-------------------");
        }
    }
    public int generarAleatorio(int maximo) {
        Random rnd = new Random();
        return rnd.nextInt(maximo + 1); 
    }
    public Carta entregarCarta() {
        if (naipe.isEmpty()) {
            return null;
        }
        int posicion = generarAleatorio(naipe.size() - 1);
        Carta cartaElegida = naipe.get(posicion);
        naipe.remove(posicion);
        return cartaElegida;
    }
}