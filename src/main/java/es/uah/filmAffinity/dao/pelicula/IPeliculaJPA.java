package es.uah.filmAffinity.dao.pelicula;

import es.uah.filmAffinity.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPeliculaJPA extends JpaRepository<Pelicula, Integer> {
    Optional<Pelicula> findByTituloIgnoreCase(String titulo);
    List<Pelicula> findByDirectorContainsIgnoreCase(String director);
    List<Pelicula> findBySagaIgnoreCase(String saga);
    @Query("SELECT p FROM Pelicula p JOIN p.generos g WHERE LOWER(g.nombre) = LOWER(:nombre)")
    List<Pelicula> findByGenerosNombreIgnoreCase(String nombre);
    @Query("SELECT p FROM Pelicula p JOIN p.actores a WHERE LOWER(a.nombre) = LOWER(:actor)")
    List<Pelicula> findByActoresIgnoreCase(String actor);
}