package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.error.CategoriaNotFoundException;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCategoriaUseCase {
    private CategoriaRepository categoriaRepository;
    public void delete(CategoriaId id){
        //categoriaRepository.deteteById(id);
        Optional<Categoria> categoriaOpcional = categoriaRepository.getById(id);
        if (!categoriaOpcional.isPresent()) {
            throw new CategoriaNotFoundException(id.getValue());
        }

        categoriaRepository.deteteById(id);
    } 
}
