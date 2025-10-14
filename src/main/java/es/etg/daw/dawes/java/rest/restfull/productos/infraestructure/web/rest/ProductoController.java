package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.CreateProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.CreateProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/productos") // le estoy diciendo que apartir de /productos vamos a trabajar
@RequiredArgsConstructor
public class ProductoController {
    private final CreateProductoService createProductoService;

	@PostMapping //Método Post
	public ResponseEntity<ProductoResponse> createProducto(@RequestBody ProductoRequest productoRequest) {
		CreateProductoCommand comando = ProductoMapper.toCommand(productoRequest); 
		Producto producto = createProductoService.createProducto(comando);
		return ResponseEntity.status(HttpStatus.CREATED).body(ProductoMapper.toResponse(producto)); //Respuestagit@github.com:julparper/dawes-springboot-restful.git
	}
}
