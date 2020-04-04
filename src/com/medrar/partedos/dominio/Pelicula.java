package com.medrar.partedos.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pelicula {
    private String titulo;
    private int duracionMinutos;
    private int edadMinima;
    private String director;
}
