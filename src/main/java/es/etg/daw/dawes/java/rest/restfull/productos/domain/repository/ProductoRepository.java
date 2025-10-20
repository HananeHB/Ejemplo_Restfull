package es.etg.daw.dawes.java.rest.restfull.productos.domain.repository;

import java.util.Optional;

public interface ProductoRepository <Producto, Integer>{
    public Optional<Producto> getByName(String name);
}
