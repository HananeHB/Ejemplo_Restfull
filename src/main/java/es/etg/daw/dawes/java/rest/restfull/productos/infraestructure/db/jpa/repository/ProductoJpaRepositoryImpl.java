package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.ProductoEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.ProductoMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductoJpaRepositoryImpl  implements ProductoRepository{
    
    private final ProductoEntityJpaRepository repository;

    
    
    @Override
    public Producto save(Producto t) {
        ProductoEntity prod = ProductoMapper.toEntity(t);
        return ProductoMapper.toDomain(repository.save(prod));
    }

    @Override
    public List<Producto> getAll() {
        return ProductoMapper.toDomain(repository.findAll());

    }

    @Override
    public Optional<Producto> getById(ProductoId id) {
        Optional<Producto> producto = null;
        Optional<ProductoEntity> pe = repository.findById(id.getValue());

        if(pe.isEmpty()){
            producto = Optional.empty();
        }else{
            producto = Optional.of(ProductoMapper.toDomain(pe.get()));
        }

        return producto;
    }

    @Override
    public void deteteById(ProductoId id) {
        repository.deleteById(id.getValue());

    }

    @Override
    public Optional<Producto> getByName(String name) {
        // ProductoEntity p = repository.findByNombre(name);
        //Optional.ofNullable envuelve la entidad p en un Optional
        // return Optional.ofNullable(ProductoMapper.toDomain(p));

        ProductoEntity prod = repository.findByNombre(name);
    
        if(prod!=null)
            // si existe lo convertimos a nuestro dominio Producto y lo envolvemos en un Optional
            return Optional.of(ProductoMapper.toDomain(prod));
        else
            //si no, devolvemos un  Opcional vacio
            return Optional.empty() ;
    }
    
}
