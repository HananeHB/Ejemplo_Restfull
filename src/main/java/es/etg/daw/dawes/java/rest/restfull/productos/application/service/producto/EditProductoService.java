package es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.EditProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditProductoService extends ProductoService {
    private final EditProductoUseCase editProductoUseCase;

    @CacheEvict (allEntries = true) //Elimina de cache la lista
    @CachePut (key="#command.id") // Agregamos a la cache la entrada con key = id (está en el comando)
    public Producto update(EditProductoCommand commando){
        Producto producto = editProductoUseCase.update(commando);
        return producto;
    }
}
