package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;

public class EditProductoUseCase {
    
    public Producto update(EditProductoCommand comando){
        // obtener el ID
       Producto producto = Producto.builder()
                                    .nombre(comando.nombre())
									.precio(comando.precio())
									.build();
    return producto;
    }
}
