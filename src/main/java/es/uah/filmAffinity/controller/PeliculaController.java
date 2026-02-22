package es.uah.filmAffinity.controller;

import es.uah.filmAffinity.dto.request.pelicula.PelicuaRequest;
import es.uah.filmAffinity.dto.response.pelicula.PeliculaResponse;
import es.uah.filmAffinity.service.pelicula.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaController {
    private final IPeliculaService peliculaService;

    @Autowired
    public PeliculaController(IPeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/films")
    public List<PeliculaResponse> findAll() {
        return this.peliculaService.findAll();
    }

    @GetMapping("/films/id/{id}")
    public PeliculaResponse findById(@PathVariable("id") Integer id) {
        return this.peliculaService.findById(id);
    }

    @GetMapping("/films/titulo/{titulo}")
    public List<PeliculaResponse> findByTituloIgnoreCase(@PathVariable("titulo") String titulo) {
        return this.peliculaService.findByTituloIgnoreCase(titulo);
    }

    @GetMapping("/films/director/{director}")
    public List<PeliculaResponse> findByDirectorContainsIgnoreCase(@PathVariable("director") String director) {
        return this.peliculaService.findByDirectorContainsIgnoreCase(director);
    }

    @GetMapping("/films/saga/{saga}")
    public List<PeliculaResponse> findBySagaIgnoreCase(@PathVariable("saga") String saga) {
        return this.peliculaService.findBySagaIgnoreCase(saga);
    }

    @GetMapping("/films/genero/{nombre}")
    public List<PeliculaResponse> findByGenerosNombreIgnoreCase(@PathVariable("nombre") String nombre) {
        return this.peliculaService.findByGenerosNombreIgnoreCase(nombre);
    }

    @GetMapping("/films/actor/{actor}")
    public List<PeliculaResponse> findByActoresIgnoreCase(@PathVariable("actor") String actor) {
        return this.peliculaService.findByActoresIgnoreCase(actor);
    }

    @PostMapping("/films")
    public PeliculaResponse save(@RequestBody PelicuaRequest pelicula) {
        return this.peliculaService.save(pelicula);
    }

    @PutMapping("/films")
    public PeliculaResponse update(@RequestBody PelicuaRequest pelicula) {
        return this.peliculaService.update(pelicula);
    }

    @DeleteMapping("/films/id/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        this.peliculaService.deleteById(id);
    }

    @GetMapping("/films/add/actor/{id}/{nombre}")
    public void addActor(@PathVariable("id") Integer id, @PathVariable("nombre") String nombre) {
        this.peliculaService.addActor(id, nombre);
    }

    @GetMapping("/films/delete/actor/{id}/{nombre}")
    public void deleteActor(@PathVariable("id") Integer id, @PathVariable("nombre") String nombre) {
        this.peliculaService.deleteActor(id, nombre);
    }

    @GetMapping("/films/add/genero/{id}/{nombre}")
    public void addGenero(@PathVariable("id") Integer id, @PathVariable("nombre") String nombre) {
        this.peliculaService.addGenero(id, nombre);
    }

    @GetMapping("/films/delete/genero/{id}/{nombre}")
    public void deleteGenero(@PathVariable("id") Integer id, @PathVariable("nombre") String nombre) {
        this.peliculaService.deleteGenero(id, nombre);
    }
}
