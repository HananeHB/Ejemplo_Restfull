package es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.EditProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditProductoService {
    private final EditProductoUseCase editProductoUseCase;

    public Producto update(EditProductoCommand commando){
        Producto producto = editProductoUseCase.update(commando);
        return producto;
    }
}
