package es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.DeleteCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeleteCategoriaService extends CategoriaService{
    private DeleteCategoriaUseCase deleteCategoriaUseCase;

    @CacheEvict //(allEntries = true) //Elimina de cache la lista
    @CachePut
    public void delete(CategoriaId id){
        deleteCategoriaUseCase.delete(id);
    }
}
