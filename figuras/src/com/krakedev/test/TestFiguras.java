package com.krakedev.test;

import com.krakedev.figuras.Cuadrado;
import com.krakedev.figuras.Triangulo;

public class TestFiguras {
    public static void main(String[] args) {
        Cuadrado c1 = new Cuadrado("Cuadrado", "Rojo", 5);
        Triangulo t1 = new Triangulo("Triángulo", "Verde", 3, 4, 5);

        System.out.println(c1);
        System.out.println(t1);
    }
}
