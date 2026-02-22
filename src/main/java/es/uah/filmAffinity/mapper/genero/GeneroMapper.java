package es.uah.filmAffinity.mapper.genero;

import es.uah.filmAffinity.dto.request.genero.GeneroRequest;
import es.uah.filmAffinity.dto.response.genero.GeneroResponse;
import es.uah.filmAffinity.dto.response.genero.GeneroResponseMin;
import es.uah.filmAffinity.model.Genero;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

@Component
public class GeneroMapper implements IGeneroMapper {
    @Override
    public Genero toNewEntity(GeneroRequest genero) {
        Genero newGenero = new Genero();
        newGenero.setId(null);
        newGenero.setNombre(genero.getNombre());
        newGenero.setDescripcion(genero.getDescripcion());
        newGenero.setPeliculas(new LinkedHashSet<>());
        return newGenero;
    }

    @Override
    public void toUpdateEntity(GeneroRequest genero, Genero existingGenero) {
        existingGenero.setNombre(genero.getNombre());
        existingGenero.setDescripcion(genero.getDescripcion());
    }

    @Override
    public GeneroResponse toResponse(Genero genero) {
        GeneroResponse response = null;
        if (genero != null) {
            response = new GeneroResponse(
                    genero.getId(),
                    genero.getNombre(),
                    genero.getDescripcion()
            );
        }
        return response;
    }

    @Override
    public GeneroResponseMin toResponseMin(Genero genero) {
        return new GeneroResponseMin(genero.getId(), genero.getNombre());
    }
}
