package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.error.ProductoNotFoundException;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProductoUseCase {
    private ProductoRepository productoRepository;
    public void delete(ProductoId id){
        //productoRepository.deteteById(id);

        Optional<Producto> productoOpcional = productoRepository.getById(id);
        if (!productoOpcional.isPresent()) {
            throw new ProductoNotFoundException(id.getValue());
        }

        productoRepository.deteteById(id);
    } 
}
