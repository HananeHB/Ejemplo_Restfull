package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.CategoriaEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.categoria.CategoriaRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.categoria.CategoriaResponse;

public class CategoriaMapper {
    public static CreateCategoriaCommand toCommand(CategoriaRequest categoriaRequest){
		return new CreateCategoriaCommand(categoriaRequest.nombre());
	}

	public static CategoriaResponse toResponse(Categoria categoria){
		return new CategoriaResponse(categoria.getId().getValue(),
                                    categoria.getNombre(),
                                    categoria.getCreatedAt());
	}

	public static EditCategoriaCommand toCommand(CategoriaId id, CategoriaRequest categoriaRequest){
		return new EditCategoriaCommand(id, categoriaRequest.nombre());
	}

	public static Categoria toDomain(CategoriaEntity p){
        return Categoria.builder().id(new CategoriaId(p.getId()))
                                 .nombre(p.getNombre())
                                 .build();

    }

    public static List<Categoria> toDomain(List<CategoriaEntity> lista){
        List<Categoria> lc = new ArrayList<>();
        for(CategoriaEntity ce: lista){
            lc.add(toDomain(ce));
        }
        return lc;
    }
}
