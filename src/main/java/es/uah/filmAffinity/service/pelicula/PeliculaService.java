package es.uah.filmAffinity.service.pelicula;

import es.uah.filmAffinity.dao.pelicula.IPeliculaDAO;
import es.uah.filmAffinity.dto.request.pelicula.PelicuaRequest;
import es.uah.filmAffinity.dto.response.pelicula.PeliculaResponse;
import es.uah.filmAffinity.mapper.pelicula.IPeliculaMapper;
import es.uah.filmAffinity.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {
    private final IPeliculaDAO peliculaDAO;
    private final IPeliculaMapper peliculaMapper;

    @Autowired
    public PeliculaService(IPeliculaDAO peliculaDAO, IPeliculaMapper peliculaMapper) {
        this.peliculaDAO = peliculaDAO;
        this.peliculaMapper = peliculaMapper;
    }

    @Override
    public List<PeliculaResponse> findAll() {
        return this.peliculaDAO.findAll().stream().map(this.peliculaMapper::toResponse).toList();
    }

    @Override
    public PeliculaResponse findById(Integer id) {
        PeliculaResponse response = null;
        if (id != null && id > 0) {
            response = this.peliculaMapper.toResponse(this.peliculaDAO.findById(id));
        }
        return response;
    }

    @Override
    public List<PeliculaResponse> findByTituloIgnoreCase(String titulo) {
        List<PeliculaResponse> peliculas = null;
        if (titulo != null && !titulo.isBlank()) {
            peliculas = this.peliculaDAO.findByTituloIgnoreCase(titulo).stream().map(this.peliculaMapper::toResponse).toList();
        }
        return peliculas;
    }

    @Override
    public List<PeliculaResponse> findByDirectorContainsIgnoreCase(String director) {
        List<PeliculaResponse> peliculas = Collections.emptyList();
        if (director != null && !director.isBlank()) {
            peliculas = this.peliculaDAO.findByDirectorContainsIgnoreCase(director).stream().map(this.peliculaMapper::toResponse).toList();
        }
        return peliculas;
    }

    @Override
    public List<PeliculaResponse> findBySagaIgnoreCase(String saga) {
        List<PeliculaResponse> peliculas = Collections.emptyList();
        if (saga != null && !saga.isBlank()) {
            peliculas = this.peliculaDAO.findBySagaIgnoreCase(saga).stream().map(this.peliculaMapper::toResponse).toList();
        }
        return peliculas;
    }

    @Override
    public List<PeliculaResponse> findByGenerosNombreIgnoreCase(String nombre) {
        List<PeliculaResponse> peliculas = Collections.emptyList();
        if (nombre != null && !nombre.isBlank()) {
            peliculas = this.peliculaDAO.findByGenerosNombreIgnoreCase(nombre).stream().map(this.peliculaMapper::toResponse).toList();
        }
        return peliculas;
    }

    @Override
    public List<PeliculaResponse> findByActoresIgnoreCase(String actor) {
        List<PeliculaResponse> peliculas = Collections.emptyList();
        if (actor != null && !actor.isBlank()) {
            peliculas = this.peliculaDAO.findByActoresIgnoreCase(actor).stream().map(this.peliculaMapper::toResponse).toList();
        }
        return peliculas;
    }

    @Override
    public PeliculaResponse save(PelicuaRequest pelicula) {
        PeliculaResponse response = null;
        if (pelicula != null) {
            response = this.peliculaMapper.toResponse(this.peliculaDAO.save(this.peliculaMapper.toNewEntity(pelicula)));
        }
        return response;
    }

    @Override
    public PeliculaResponse update(PelicuaRequest pelicula) {
        PeliculaResponse response = null;
        if (pelicula != null && pelicula.getId() != null && pelicula.getId() > 0) {
            Pelicula aux = this.peliculaDAO.findById(pelicula.getId());
            if (aux != null) {
                this.peliculaMapper.toUpdatePelicula(pelicula, aux);
                this.peliculaDAO.update(aux);
                response = this.peliculaMapper.toResponse(aux);
            }
        }
        return response;
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
