package org.example;

/**
 * Clase que representa una calculadora básica con operaciones aritméticas.
 * Permite sumar, restar, multiplicar y dividir números enteros.
 *
 * @author Germán Gascón
 * @version 1.1
 */
public class Calculadora {

    /**
     * Suma dos números enteros.
     *
     * @param a primer número
     * @param b segundo número
     * @return resultado de la suma
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números enteros.
     *
     * @param a primer número
     * @param b segundo número
     * @return resultado de la resta
     */
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números enteros.
     *
     * @param a primer número
     * @param b segundo número
     * @return resultado de la multiplicación
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dos números enteros.
     *
     * @param a dividendo
     * @param b divisor (no puede ser 0)
     * @return resultado de la división
     * @throws ArithmeticException si el divisor es 0
     */
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Error: no se puede dividir entre 0");
        }
        return a / b;
    }
}
