package es.etg.daw.dawes.java.rest.restfull.productos.domain.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import es.etg.daw.dawes.java.rest.restfull.common.domain.error.EntityNotFoundException;

// Al añadir esta anotación, Spring sabe que cuando se lance esta excepción,
// debe responder con un estado 404 NOT FOUND.
//LO he agregado por la prueba en el testing, si no encuentra el producto
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductoNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "producto";

    public ProductoNotFoundException(){
        super(ENTIDAD);
    }

    public ProductoNotFoundException(int id){
        super(ENTIDAD, id);
    }
    
}