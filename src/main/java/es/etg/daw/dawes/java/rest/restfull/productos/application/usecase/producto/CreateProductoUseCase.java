package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.CreateProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProductoUseCase {
	private ProductoRepository productoRepository;

	public Producto create(CreateProductoCommand comando) {


		Producto producto = Producto.builder()
				.nombre(comando.nombre())
				.precio(comando.precio())
				.categoria(comando.categoria())
				.createdAt(LocalDateTime.now()).build();

		productoRepository.save(producto);
		return producto;

	}
}
