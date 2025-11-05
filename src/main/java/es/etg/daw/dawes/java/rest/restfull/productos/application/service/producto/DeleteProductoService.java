package es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.DeleteProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteProductoService extends ProductoService{
    private final DeleteProductoUseCase deleteProductoUseCase;

    @CacheEvict //(allEntries = true) //Elimina de cache la lista
    @CachePut

    public void delete(ProductoId id){
        deleteProductoUseCase.delete(id);
    }
}
