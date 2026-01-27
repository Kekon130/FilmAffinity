package es.uah.filmAffinity.service.pelicula;

import es.uah.filmAffinity.dao.pelicula.IPeliculaDAO;
import es.uah.filmAffinity.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {
    private IPeliculaDAO peliculaDAO;

    @Autowired
    public PeliculaService(IPeliculaDAO peliculaDAO) {
        this.peliculaDAO = peliculaDAO;
    }

    @Override
    public List<Pelicula> findAll() {
        return this.peliculaDAO.findAll();
    }

    @Override
    public Pelicula findById(Integer id) {
        Pelicula pelicula = null;
        if (id != null && id > 0) {
            pelicula = this.peliculaDAO.findById(id);
        }
        return pelicula;
    }

    @Override
    public List<Pelicula> findByTituloIgnoreCase(String titulo) {
        List<Pelicula> peliculas = null;
        if (titulo != null && !titulo.isBlank()) {
            peliculas = this.peliculaDAO.findByTituloIgnoreCase(titulo);
        }
        return peliculas;
    }

    @Override
    public List<Pelicula> findByDirectorContainsIgnoreCase(String director) {
        List<Pelicula> peliculas = Collections.emptyList();
        if (director != null && !director.isBlank()) {
            peliculas = this.peliculaDAO.findByDirectorContainsIgnoreCase(director);
        }
        return peliculas;
    }

    @Override
    public List<Pelicula> findBySagaIgnoreCase(String saga) {
        List<Pelicula> peliculas = Collections.emptyList();
        if (saga != null && !saga.isBlank()) {
            peliculas = this.peliculaDAO.findBySagaIgnoreCase(saga);
        }
        return peliculas;
    }

    @Override
    public List<Pelicula> findByGenerosNombreIgnoreCase(String nombre) {
        List<Pelicula> peliculas = Collections.emptyList();
        if (nombre != null && !nombre.isBlank()) {
            peliculas = this.peliculaDAO.findByGenerosNombreIgnoreCase(nombre);
        }
        return peliculas;
    }

    @Override
    public List<Pelicula> findByActoresIgnoreCase(String actor) {
        List<Pelicula> peliculas = Collections.emptyList();
        if (actor != null && !actor.isBlank()) {
            peliculas = this.peliculaDAO.findByActoresIgnoreCase(actor);
        }
        return peliculas;
    }

    @Override
    public Pelicula save(Pelicula pelicula) {
        Pelicula savedPelicula = null;
        if (pelicula != null && (pelicula.getId() == null || pelicula.getId() == 0)) {
            pelicula.setId(null);
            savedPelicula = this.peliculaDAO.save(pelicula);
        }
        return savedPelicula;
    }

    @Override
    public Pelicula update(Pelicula pelicula) {
        Pelicula updatedPelicula = null;
        if (pelicula != null && pelicula.getId() != null && pelicula.getId() > 0) {
            updatedPelicula = this.peliculaDAO.update(pelicula);
        }
        return updatedPelicula;
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && id > 0) {
            this.peliculaDAO.deleteById(id);
        }
    }

    @Override
    public void addActor(Integer id, String nombre) {
        if (id != null && id > 0 && nombre != null && !nombre.isBlank()) {
            this.peliculaDAO.addActor(id, nombre);
        }
    }

    @Override
    public void deleteActor(Integer id, String nombre) {
        if (id != null && id > 0 && nombre != null && !nombre.isBlank()) {
            this.peliculaDAO.deleteActor(id, nombre);
        }
    }

    @Override
    public void addGenero(Integer id, String nombre) {
        if (id != null && id > 0 && nombre != null && !nombre.isBlank()) {
            this.peliculaDAO.addGenero(id, nombre);
        }
    }

    @Override
    public void deleteGenero(Integer id, String nombre) {
        if (id != null && id > 0 && nombre != null && !nombre.isBlank()) {
            this.peliculaDAO.deleteGenero(id, nombre);
        }
    }
}
