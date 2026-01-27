package es.uah.filmAffinity.service.genero;

import es.uah.filmAffinity.model.Genero;

import java.util.List;

public interface IGeneroService {
    Genero getGeneroById(Integer id);
    List<Genero> getGeneros();
    Genero createGenero(Genero genero);
    Genero updateGenero(Genero genero);
    void deleteGeneroById(Integer id);
}
