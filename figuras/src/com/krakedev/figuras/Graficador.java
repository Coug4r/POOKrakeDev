package com.krakedev.figuras;

public class Graficador {
    public void graficar(Figura figura) {
        System.out.println("Graficando " + figura.getNombre() +
                           " de color " + figura.getColor() +
                           " con perímetro " + figura.calcularPerimetro() +
                           " y área " + figura.calcularArea());
    }
}
