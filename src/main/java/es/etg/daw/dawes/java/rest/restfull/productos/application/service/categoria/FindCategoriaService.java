package es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.FindeCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindCategoriaService extends CategoriaService{
    private final FindeCategoriaUseCase findeCategoriaUseCase;

    @Cacheable //Cacheamos la lista LISTA | COLECCION
    public List<Categoria> findAll() {
        return findeCategoriaUseCase.findAll();
     }
}
