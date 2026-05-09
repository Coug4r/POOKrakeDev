package com.krakedev.test;

import com.krakedev.figuras.*;

public class TestPerimetro {
    public static void main(String[] args) {
        Cuadrado c1 = new Cuadrado("Cuadrado", "Rojo", 5);
        Rectangulo r1 = new Rectangulo("Rectángulo", "Azul", 4, 6);

        System.out.println("Perímetro del cuadrado: " + c1.calcularPerimetro());
        System.out.println("Perímetro del rectángulo: " + r1.calcularPerimetro());
    }
}
