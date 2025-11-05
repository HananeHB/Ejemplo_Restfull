package es.etg.daw.dawes.java.rest.restfull.common.domain.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;

public interface CRUDRepository <T , ID>{
    public T save(T t);
    public List<T> getAll();
    public Optional<T> getById(ID id);
    public void deteteById(ProductoId id); 
}


