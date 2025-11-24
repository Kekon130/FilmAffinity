package es.uah.filmAffinity.service.pelicula;

import es.uah.filmAffinity.model.Pelicula;

import java.util.List;

public interface IPeliculaService {
    List<Pelicula> findAll();
    Pelicula findById(Integer id);
    Pelicula findByTituloIgnoreCase(String titulo);
    List<Pelicula> findByDirectorContainsIgnoreCase(String director);
    List<Pelicula> findBySagaIgnoreCase(String saga);
    List<Pelicula> findByGenerosNombreIgnoreCase(String nombre);
    List<Pelicula> findByActoresIgnoreCase(String actor);
    Pelicula save(Pelicula pelicula);
    Pelicula update(Pelicula pelicula);
    void deleteById(Integer id);
}
