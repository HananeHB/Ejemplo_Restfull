package es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.FindProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindProductoService extends ProductoService {
    private final FindProductoUseCase findProductoUseCase;

     @Cacheable //Cacheamos la lista LISTA | COLECCION
     public List<Producto> findAll() {
        return findProductoUseCase.findAll();
     }
}
