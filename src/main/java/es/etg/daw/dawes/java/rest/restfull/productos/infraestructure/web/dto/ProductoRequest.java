package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductoRequest(
                // El nombre no puede estar en blanco
                @NotBlank 
                    String nombre, 
                  // El precio tiene que estar entre 0 y 100
                @Min(value = 0) 
                @Max(value = 100)
                    double precio){
    
}
