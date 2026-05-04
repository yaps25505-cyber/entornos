package org.example;

/**
 * Clase que representa un temporizador en segundos.
 */
public class Temporizador {

    /** Cantidad actual de segundos */
    private int segundos;

    /**
     * Constructor del temporizador.
     *
     * @param segundosIniciales segundos iniciales del temporizador
     */
    public Temporizador(int segundosIniciales) {
        this.segundos = segundosIniciales;
    }

    /**
     * Incrementa el tiempo del temporizador.
     *
     * @param segundosExtra cantidad de segundos a añadir
     * @throws IllegalArgumentException si el valor es negativo
     */
    public void incrementar(int segundosExtra) {
        if (segundosExtra < 0) {
            throw new IllegalArgumentException("No se permiten valores negativos");
        }
        segundos += segundosExtra;
    }

    /**
     * Reinicia el temporizador a 0.
     */
    public void reiniciar() {
        segundos = 0;
    }

    /**
     * Obtiene los segundos actuales.
     *
     * @return segundos actuales
     */
    public int getSegundos() {
        return segundos;
    }
}
