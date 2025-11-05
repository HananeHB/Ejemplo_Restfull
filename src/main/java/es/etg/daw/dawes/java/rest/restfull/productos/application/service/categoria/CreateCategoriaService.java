package es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.CreateCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreateCategoriaService extends CategoriaService{
    private CreateCategoriaUseCase createCategoriaUseCase;

    @CacheEvict (allEntries = true) //Elimina de cache la lista
	public Categoria createProducto(CreateCategoriaCommand comando){
		Categoria categoria = createCategoriaUseCase.create(comando);
		return categoria;
	}
}
