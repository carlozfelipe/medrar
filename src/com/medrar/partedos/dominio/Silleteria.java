package com.medrar.partedos.dominio;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Silleteria {
    private static final int TOTAL_SILLAS = 72;
    private Map<String, Boolean> sillasLibres;
    private byte numeroSillasLibres;
    public Silleteria(){
        numeroSillasLibres = TOTAL_SILLAS;
        sillasLibres = new HashMap<>();
        for(int i=1;i<9;i++){
            sillasLibres.put(i + "A", Boolean.TRUE);
            sillasLibres.put(i + "B", Boolean.TRUE);
            sillasLibres.put(i + "C", Boolean.TRUE);
            sillasLibres.put(i + "D", Boolean.TRUE);
            sillasLibres.put(i + "E", Boolean.TRUE);
            sillasLibres.put(i + "F", Boolean.TRUE);
            sillasLibres.put(i + "G", Boolean.TRUE);
            sillasLibres.put(i + "H", Boolean.TRUE);
            sillasLibres.put(i + "I", Boolean.TRUE);
        }
    }

    private boolean sillaLibre(String numeroSilla){
        if(sillasLibres.containsKey(numeroSilla)){
            return sillasLibres.get(numeroSilla);
        }
        return false;
    }

    public boolean ocuparSilla(String numeroSilla){
        if(sillaLibre(numeroSilla)){
            sillasLibres.put(numeroSilla, Boolean.FALSE);
            numeroSillasLibres--;
            return true;
        }
        return false;
    }

    public int numeroSillasOcupadas(){
        return TOTAL_SILLAS - numeroSillasLibres;
    }
}
