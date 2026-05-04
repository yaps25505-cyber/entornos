package org.example;

/**
 * Representa un jugador de fútbol.
 */
public class Jugador {

    String nombre;
    int dorsal;
    int portero;
    int defensa;
    int regate;
    int pase;
    int tiro;

    public Jugador(String nombre, int dorsal, int portero, int defensa, int regate, int pase, int tiro) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.portero = portero;
        this.defensa = defensa;
        this.regate = regate;
        this.pase = pase;
        this.tiro = tiro;
    }
}

public class Equipo {

    String nombre;
    Jugador[] jugadores = new Jugador[11];
    int goles;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.goles = 0;
    }
}

public class Pelota {

    Equipo equipo;
    int posicion;

    public Pelota(Equipo equipo) {
        this.equipo = equipo;
        this.posicion = 0;
    }
}
public class Narrador {

    public void narrar(String texto) {
        System.out.println(texto);
    }
}
public class Partido {

    public static void main(String[] args) throws InterruptedException {

        Random r = new Random();
        Narrador narrador = new Narrador();

        Equipo equipo1 = crearEquipo("Equipo A");
        Equipo equipo2 = crearEquipo("Equipo B");

        Equipo equipoActual = r.nextBoolean() ? equipo1 : equipo2;
        Pelota pelota = new Pelota(equipoActual);

        long inicio = System.currentTimeMillis();

        narrador.narrar("¡Comienza el partido!");

        while (System.currentTimeMillis() - inicio < 60000) { // 1 minuto para que no sea eterno

            Jugador jugador = pelota.equipo.jugadores[pelota.posicion];
            Jugador rival = obtenerRival(pelota, equipo1, equipo2);

            int accion = r.nextInt(3); // 0 pase, 1 regate, 2 tiro

            if (accion == 0 && pelota.posicion < 10) {
                if (jugador.pase > rival.defensa) {
                    pelota.posicion++;
                    narrador.narrar(jugador.nombre + " hace un pase");
                } else {
                    cambiarPosesion(pelota, equipo1, equipo2);
                    narrador.narrar("¡Robo del rival!");
                }

            } else if (accion == 1 && pelota.posicion < 10) {
                if (jugador.regate > rival.defensa) {
                    pelota.posicion++;
                    narrador.narrar(jugador.nombre + " regatea");
                } else {
                    cambiarPosesion(pelota, equipo1, equipo2);
                    narrador.narrar("Pierde el balón");
                }

            } else if (pelota.posicion >= 7) {
                if (jugador.tiro > rival.portero) {
                    pelota.equipo.goles++;
                    narrador.narrar("¡¡GOOOOL!!");
                    pelota.posicion = 0;
                } else {
                    narrador.narrar("El portero para");
                    cambiarPosesion(pelota, equipo1, equipo2);
                }
            }

            Thread.sleep(2000);
        }

        narrador.narrar("Fin del partido");
        narrador.narrar(equipo1.nombre + " " + equipo1.goles + " - " + equipo2.goles + " " + equipo2.nombre);
    }

    public static Equipo crearEquipo(String nombre) {
        Random r = new Random();
        Equipo e = new Equipo(nombre);

        for (int i = 0; i < 11; i++) {
            e.jugadores[i] = new Jugador(
                    "Jugador" + i,
                    i,
                    r.nextInt(100),
                    r.nextInt(100),
                    r.nextInt(100),
                    r.nextInt(100),
                    r.nextInt(100)
            );
        }
        return e;
    }

    public static Jugador obtenerRival(Pelota pelota, Equipo e1, Equipo e2) {
        Equipo rivalEquipo = (pelota.equipo == e1) ? e2 : e1;
        return rivalEquipo.jugadores[10 - pelota.posicion];
    }

    public static void cambiarPosesion(Pelota pelota, Equipo e1, Equipo e2) {
        pelota.equipo = (pelota.equipo == e1) ? e2 : e1;
        pelota.posicion = 0;
    }
}
