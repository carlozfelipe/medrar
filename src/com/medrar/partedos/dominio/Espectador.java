package com.medrar.partedos.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Espectador {
    private String nombre;
    private int edad;
    private int dinero;

}
