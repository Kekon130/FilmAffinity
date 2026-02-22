package es.uah.filmAffinity.mapper.pelicula;

import es.uah.filmAffinity.dto.request.pelicula.PelicuaRequest;
import es.uah.filmAffinity.dto.response.pelicula.PeliculaResponse;
import es.uah.filmAffinity.mapper.actor.IActorMapper;
import es.uah.filmAffinity.mapper.genero.IGeneroMapper;
import es.uah.filmAffinity.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

@Component
public class PeliculaMapper implements IPeliculaMapper {
    private final IActorMapper actorMapper;
    private final IGeneroMapper generoMapper;

    @Autowired
    public PeliculaMapper(IActorMapper actorMapper, IGeneroMapper generoMapper) {
        this.actorMapper = actorMapper;
        this.generoMapper = generoMapper;
    }

    @Override
    public Pelicula toNewEntity(PelicuaRequest pelicula) {
        Pelicula newPelicula = new Pelicula();
        newPelicula.setId(null);
        newPelicula.setTitulo(pelicula.getTitulo());
        newPelicula.setAnioEstreno(pelicula.getAnioEstreno());
        newPelicula.setDirector(pelicula.getDirector());
        newPelicula.setDuracion(pelicula.getDuracion());
        newPelicula.setPais(pelicula.getPais());
        newPelicula.setSinopsis(pelicula.getSinopsis());
        newPelicula.setPortada(pelicula.getPortada());
        newPelicula.setSaga(pelicula.getSaga());
        newPelicula.setActores(new LinkedHashSet<>());
        newPelicula.setGeneros(new LinkedHashSet<>());
        return newPelicula;
    }

    @Override
    public void toUpdatePelicula(PelicuaRequest pelicula, Pelicula existingpelicula) {
        existingpelicula.setId(pelicula.getId());
        existingpelicula.setTitulo(pelicula.getTitulo());
        existingpelicula.setAnioEstreno(pelicula.getAnioEstreno());
        existingpelicula.setDirector(pelicula.getDirector());
        existingpelicula.setDuracion(pelicula.getDuracion());
        existingpelicula.setPais(pelicula.getPais());
        existingpelicula.setSinopsis(pelicula.getSinopsis());
        existingpelicula.setPortada(pelicula.getPortada());
        existingpelicula.setSaga(pelicula.getSaga());
    }

    @Override
    public PeliculaResponse toResponse(Pelicula pelicula) {
        PeliculaResponse response = null;
        if (pelicula != null) {
            response = new PeliculaResponse(
                    pelicula.getId(),
                    pelicula.getTitulo(),
                    pelicula.getAnioEstreno(),
                    pelicula.getDirector(),
                    pelicula.getDuracion(),
                    pelicula.getPais(),
                    pelicula.getSinopsis(),
                    pelicula.getPortada(),
                    pelicula.getSaga(),
                    pelicula.getActores().stream().map(this.actorMapper::toResponseMin).toList(),
                    pelicula.getGeneros().stream().map(this.generoMapper::toResponseMin).toList()
            );
        }
        return response;
    }
}
