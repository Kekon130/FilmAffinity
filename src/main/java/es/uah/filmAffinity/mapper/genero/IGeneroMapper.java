package es.uah.filmAffinity.mapper.genero;

import es.uah.filmAffinity.dto.request.genero.GeneroRequest;
import es.uah.filmAffinity.dto.response.genero.GeneroResponse;
import es.uah.filmAffinity.dto.response.genero.GeneroResponseMin;
import es.uah.filmAffinity.model.Genero;

public interface IGeneroMapper {
    Genero toNewEntity(GeneroRequest genero);
    void toUpdateEntity(GeneroRequest genero, Genero existingGenero);
    GeneroResponse toResponse(Genero genero);
    GeneroResponseMin toResponseMin(Genero genero);
}
