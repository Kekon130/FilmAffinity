package es.uah.filmAffinity.dao.pelicula;

import es.uah.filmAffinity.model.Pelicula;

import java.util.List;

public interface IPeliculaDAO {
    List<Pelicula> findAll();
    Pelicula findById(Integer id);
    List<Pelicula> findByTituloIgnoreCase(String titulo);
    List<Pelicula> findByDirectorContainsIgnoreCase(String director);
    List<Pelicula> findBySagaIgnoreCase(String saga);
    List<Pelicula> findByGenerosNombreIgnoreCase(String nombre);
    List<Pelicula> findByActoresIgnoreCase(String actor);
    Pelicula save(Pelicula pelicula);
    Pelicula update(Pelicula pelicula);
    void deleteById(Integer id);
    void addActor(Integer id, String nombre);
    void deleteActor(Integer id, String nombre);
    void addGenero(Integer id, String nombre);
    void deleteGenero(Integer id, String nombre);
}
