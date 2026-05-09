package com.krakedev.figuras;

public class Triangulo extends Figura {
    private int ladoA;
    private int ladoB;
    private int ladoC;

    public Triangulo(String nombre, String color, int ladoA, int ladoB, int ladoC) {
        super(nombre, color);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public int calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }

    @Override
    public double calcularArea() {
        double s = calcularPerimetro() / 2.0;
        return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }

    @Override
    public String toString() {
        return "Triángulo: lados=" + ladoA + "," + ladoB + "," + ladoC + ", color=" + getColor();
    }
}