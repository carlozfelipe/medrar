package com.medrar.partedos.servicios;

import com.medrar.partedos.dominio.Espectador;
import com.medrar.partedos.dominio.Sala;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ServicioSala {
    private static final String[] COLUMNA = {"A","B","C","D","E","F","G","H","I"};
    private static final String[] FILA = {"1","2","3","4","5","6","7","8"};

    private static String seleccionarSilla(){
        Random random = new Random();
        int col = random.ints(1,0,9).findFirst().getAsInt();
        int fil = random.ints(1,0,8).findFirst().getAsInt();
        return FILA[fil]+COLUMNA[col];
    }

    public static void sentarEspectadores(List<Espectador> espectadores, Sala sala){

        long espectadoresSentados =espectadores.stream().filter(e->e.getDinero()>=sala.getPrecioTiquete()&&
                e.getEdad()>=sala.getPelicula().getEdadMinima()&&
                sala.getSilleteria().ocuparSilla(seleccionarSilla())).count();
        System.out.println("Espectadores sentados: "+ espectadoresSentados);

    }
}
