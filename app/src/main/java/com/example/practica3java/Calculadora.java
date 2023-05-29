package com.example.practica3java;

public class Calculadora {
    // Declarar las variables
    private Integer num1;
    private Integer num2;

    // Constructor
    public Calculadora(Integer num1, Integer num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Funciones de la calculadora
    public Integer suma() {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("No se pueden realizar operaciones sin números.");
        }
        return num1 + num2;
    }

    public Integer resta() {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("No se pueden realizar operaciones sin números.");
        }
        return num1 - num2;
    }

    public Integer multiplicacion() {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("No se pueden realizar operaciones sin números.");
        }
        return num1 * num2;
    }

    public Integer division() {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("No se pueden realizar operaciones sin números.");
        }
        return num1 / num2;
    }
}
