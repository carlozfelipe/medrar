package com.medrar.partedos.dominio;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class Sala {
    private Pelicula pelicula;
    private int precioTiquete;
    private Silleteria silleteria;

    public Sala(Pelicula pelicula, int precioTiquete){
        this.precioTiquete = precioTiquete;
        this.pelicula = pelicula;
        silleteria = new Silleteria();
    }

    public int numeroSillasLibres(){
        return silleteria.getNumeroSillasLibres();
    }

    public int numeroSillasOcupadas(){
        return silleteria.numeroSillasOcupadas();
    }



}
