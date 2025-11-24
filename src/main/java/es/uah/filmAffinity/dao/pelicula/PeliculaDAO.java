package es.uah.filmAffinity.dao.pelicula;

import es.uah.filmAffinity.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaDAO implements IPeliculaDAO {
    private IPeliculaJPA peliculaJPA;

    @Autowired
    public PeliculaDAO(IPeliculaJPA peliculaJPA) {
        this.peliculaJPA = peliculaJPA;
    }

    @Override
    public List<Pelicula> findAll() {
        return this.peliculaJPA.findAll();
    }

    @Override
    public Pelicula findById(Integer id) {
        return this.peliculaJPA.findById(id).orElse(null);
    }

    @Override
    public Pelicula findByTituloIgnoreCase(String titulo) {
        return  this.peliculaJPA.findByTituloIgnoreCase(titulo).orElse(null);
    }

    @Override
    public List<Pelicula> findByDirectorContainsIgnoreCase(String director) {
        return this.peliculaJPA.findByDirectorContainsIgnoreCase(director);
    }

    @Override
    public List<Pelicula> findBySagaIgnoreCase(String saga) {
        return this.peliculaJPA.findBySagaIgnoreCase(saga);
    }

    @Override
    public List<Pelicula> findByGenerosNombreIgnoreCase(String nombre) {
        return this.peliculaJPA.findByGenerosNombreIgnoreCase(nombre);
    }

    @Override
    public List<Pelicula> findByActoresIgnoreCase(String actor) {
        return this.peliculaJPA.findByActoresIgnoreCase(actor);
    }

    @Override
    public Pelicula save(Pelicula pelicula) {
        return Optional.ofNullable(this.peliculaJPA.save(pelicula)).orElse(null);
    }

    @Override
    public Pelicula update(Pelicula pelicula) {
        Pelicula updatedPelicula = null;
        if (this.peliculaJPA.existsById(pelicula.getId())) {
            updatedPelicula = this.peliculaJPA.save(pelicula);
        }
        return updatedPelicula;
    }

    @Override
    public void deleteById(Integer id) {
        if (this.peliculaJPA.existsById(id)) {
            this.peliculaJPA.deleteById(id);
        }
    }
}
