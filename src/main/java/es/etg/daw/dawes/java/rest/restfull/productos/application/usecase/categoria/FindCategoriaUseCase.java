package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria;

import java.util.List;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.error.ProductoNotFoundException;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindeCategoriaUseCase {
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        List<Categoria> categorias = categoriaRepository.getAll();

        if (categorias.isEmpty())
            throw new ProductoNotFoundException();

        return categorias;
    }
}
