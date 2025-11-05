package es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.EditCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EditCategoriaService extends CategoriaService{
    private EditCategoriaUseCase editCategoriaUseCase;

    @CacheEvict (allEntries = true) //Elimina de cache la lista
    @CachePut (key="#command.id") // Agregamos a la cache la entrada con key = id (está en el comando)
    public Categoria update(EditCategoriaCommand commando){
        Categoria categoria = editCategoriaUseCase.update(commando);
        return categoria;
    }
}
