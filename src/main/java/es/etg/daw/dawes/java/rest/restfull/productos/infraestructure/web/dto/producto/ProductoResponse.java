package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.producto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** * Indica a Jackson que ignore cualquier campo JSON no definido aquí (ej: "date", "status").
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductoResponse(int id, String nombre, double precio,LocalDateTime createdAt,int categoria) {
    
}
