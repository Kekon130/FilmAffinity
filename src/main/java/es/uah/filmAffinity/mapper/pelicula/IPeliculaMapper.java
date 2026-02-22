package es.uah.filmAffinity.mapper.pelicula;

import es.uah.filmAffinity.dto.request.pelicula.PelicuaRequest;
import es.uah.filmAffinity.dto.response.pelicula.PeliculaResponse;
import es.uah.filmAffinity.model.Pelicula;

public interface IPeliculaMapper {
    Pelicula toNewEntity(PelicuaRequest pelicula);
    void toUpdatePelicula(PelicuaRequest pelicula, Pelicula existingpelicula);
    PeliculaResponse toResponse(Pelicula pelicula);
}
