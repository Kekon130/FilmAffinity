package es.uah.filmAffinity.service.genero;

import es.uah.filmAffinity.dto.request.genero.GeneroRequest;
import es.uah.filmAffinity.dto.response.genero.GeneroResponse;

import java.util.List;

public interface IGeneroService {
    List<GeneroResponse> getGeneros();
    GeneroResponse getGeneroById(Integer id);
    GeneroResponse createGenero(GeneroRequest genero);
    GeneroResponse updateGenero(GeneroRequest genero);
    void deleteGeneroById(Integer id);
}
