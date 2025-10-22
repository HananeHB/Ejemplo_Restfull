package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteProductoUseCase {
    private ProductoRepository productoRepository;
    public void delete(int id){
        productoRepository.deteteById(id);
    } 
}
