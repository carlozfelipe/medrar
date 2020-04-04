package com.medrar.partedos;

import com.medrar.partedos.dominio.Espectador;
import com.medrar.partedos.dominio.Pelicula;
import com.medrar.partedos.dominio.Sala;
import com.medrar.partedos.servicios.ServicioSala;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainParteDos {
    public static void main(String[] args) {
        List<Espectador> espectadores = generarEspectadores();
        List<Pelicula> peliculas = generarPeliculas();
        espectadores.stream().forEach(System.out::println);
        peliculas.stream().forEach(System.out::println);
        Sala sala = inicializarSala(peliculas);
        System.out.println("Pelicula seleccionada: "+sala.getPelicula());
        ServicioSala.sentarEspectadores(espectadores, sala);
        System.out.println("Película en reproducción: " + sala.getPelicula());
        System.out.println("Sillas ocupadas: "+ sala.numeroSillasOcupadas());
        System.out.println("Sillas libres: " + sala.numeroSillasLibres());
        System.out.println("Precio tiquete: " + sala.getPrecioTiquete());


    }

    private static Sala inicializarSala(List<Pelicula> peliculas) {
        Random random = new Random();
        int numeroPelicula = random.ints(1,0,10).findFirst().getAsInt();
        int precio = random.ints(1,5,12).findFirst().getAsInt()*1000;
        Sala sala = new Sala(peliculas.get(numeroPelicula), precio);
        return sala;
    }

    private static List<Pelicula> generarPeliculas() {
        String director = "Nombre director ";
        String titulo = "Nombre Película ";
        List<Pelicula> peliculas = new ArrayList<>();
        Random random = new Random();
        int[] edades = random.ints(10,3,21).toArray();
        int[] duracion = random.ints(10,90,120).toArray();
        Pelicula pelicula;

        for(int i=0; i<10; i++){
            pelicula = new Pelicula(titulo+i, duracion[i],edades[i],director+i);
            peliculas.add(pelicula);
        }

        return peliculas;
    }

    private static List<Espectador> generarEspectadores() {
        String nombre = "nombre";
        List<Espectador> espectadores = new ArrayList<>();
        Random random = new Random();
        int[] edades = random.ints(200,3,120).toArray();
        int[] dinero = random.ints(200,10,120).toArray();
        Espectador espectador;

        for(int i=0; i<200; i++){
            espectador = new Espectador(nombre+i, edades[i],dinero[i]*100);
            espectadores.add(espectador);
        }

        return espectadores;

    }
}
