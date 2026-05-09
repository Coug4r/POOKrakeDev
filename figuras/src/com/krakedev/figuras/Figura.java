package com.krakedev.figuras;

public abstract class Figura {
    private String nombre;
    private String color;

    public Figura(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Figura: " + nombre + " de color " + color;
    }

    public abstract int calcularPerimetro();
    public abstract double calcularArea();
}
