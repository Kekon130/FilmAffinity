package es.uah.filmAffinity.service.pelicula;

import es.uah.filmAffinity.dto.request.pelicula.PelicuaRequest;
import es.uah.filmAffinity.dto.response.pelicula.PeliculaResponse;

import java.util.List;

public interface IPeliculaService {
    List<PeliculaResponse> findAll();
    PeliculaResponse findById(Integer id);
    List<PeliculaResponse> findByTituloIgnoreCase(String titulo);
    List<PeliculaResponse> findByDirectorContainsIgnoreCase(String director);
    List<PeliculaResponse> findBySagaIgnoreCase(String saga);
    List<PeliculaResponse> findByGenerosNombreIgnoreCase(String nombre);
    List<PeliculaResponse> findByActoresIgnoreCase(String actor);
    PeliculaResponse save(PelicuaRequest pelicula);
    PeliculaResponse update(PelicuaRequest pelicula);
    void deleteById(Integer id);
    void addActor(Integer id, String nombre);
    void deleteActor(Integer id, String nombre);
    void addGenero(Integer id, String nombre);
    void deleteGenero(Integer id, String nombre);
}
