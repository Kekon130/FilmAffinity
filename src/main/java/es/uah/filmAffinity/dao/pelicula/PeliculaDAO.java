package es.uah.filmAffinity.dao.pelicula;

import es.uah.filmAffinity.dao.actor.IActorDAO;
import es.uah.filmAffinity.dao.actor.IActorJPA;
import es.uah.filmAffinity.dao.genero.IGeneroDAO;
import es.uah.filmAffinity.dao.genero.IGeneroJPA;
import es.uah.filmAffinity.model.Actor;
import es.uah.filmAffinity.model.Genero;
import es.uah.filmAffinity.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeliculaDAO implements IPeliculaDAO {
    private IPeliculaJPA peliculaJPA;
    private IActorDAO actorDAO;
    private IGeneroDAO generoDAO;

    @Autowired
    public PeliculaDAO(IPeliculaJPA peliculaJPA, IActorDAO actorDAO, IGeneroDAO generoDAO) {
        this.peliculaJPA = peliculaJPA;
        this.actorDAO = actorDAO;
        this.generoDAO = generoDAO;
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
    public List<Pelicula> findByTituloIgnoreCase(String titulo) {
        return this.peliculaJPA.findByTituloIgnoreCase(titulo);
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

    @Override
    public void addActor(Integer id, String nombre) {
        Optional<Pelicula> optionalPelicula = this.peliculaJPA.findById(id);
        if (optionalPelicula.isPresent()) {
            Pelicula pelicula = optionalPelicula.get();
            Actor actor = this.actorDAO.findByNombreIgnoreCase(nombre);
            if (actor != null) {
                pelicula.addActor(actor);
                this.peliculaJPA.save(pelicula);
            }
        }
    }

    @Override
    public void deleteActor(Integer id, String nombre) {
        Optional<Pelicula> optionalPelicula = this.peliculaJPA.findById(id);
        if (optionalPelicula.isPresent()) {
            Pelicula pelicula = optionalPelicula.get();
            Actor actor = this.actorDAO.findByNombreIgnoreCase(nombre);
            if (actor != null && pelicula.getActores().contains(actor)) {
                pelicula.removeActor(actor);
                this.peliculaJPA.save(pelicula);
            }
        }
    }

    @Override
    public void addGenero(Integer id, String nombre) {
        Optional<Pelicula> optionalPelicula = this.peliculaJPA.findById(id);
        if (optionalPelicula.isPresent()) {
            Pelicula pelicula = optionalPelicula.get();
            Genero genero = this.generoDAO.findByNombreIgnoreCase(nombre);
            if (genero != null) {
                pelicula.addGenero(genero);
                this.peliculaJPA.save(pelicula);
            }
        }
    }

    @Override
    public void deleteGenero(Integer id, String nombre) {
        Optional<Pelicula> optionalPelicula = this.peliculaJPA.findById(id);
        if (optionalPelicula.isPresent()) {
            Pelicula pelicula = optionalPelicula.get();
            Genero genero = this.generoDAO.findByNombreIgnoreCase(nombre);
            if (genero != null && pelicula.getGeneros().contains(genero)) {
                pelicula.removeGenero(genero);
                this.peliculaJPA.save(pelicula);
            }
        }
    }
}
