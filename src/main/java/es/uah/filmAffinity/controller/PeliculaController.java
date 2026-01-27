package es.uah.filmAffinity.controller;

import es.uah.filmAffinity.model.Pelicula;
import es.uah.filmAffinity.service.pelicula.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaController {
    private IPeliculaService peliculaService;

    @Autowired
    public PeliculaController(IPeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/peliculas")
    public List<Pelicula> findAll() {
        return this.peliculaService.findAll();
    }

    @GetMapping("/peliculas/id/{id}")
    public Pelicula findById(@PathVariable("id") Integer id) {
        return this.peliculaService.findById(id);
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Pelicula> findByTituloIgnoreCase(@PathVariable("titulo") String titulo) {
        return this.peliculaService.findByTituloIgnoreCase(titulo);
    }

    @GetMapping("/peliculas/director/{director}")
    public List<Pelicula> findByDirectorContainsIgnoreCase(@PathVariable("director") String director) {
        return this.peliculaService.findByDirectorContainsIgnoreCase(director);
    }

    @GetMapping("/peliculas/saga/{saga}")
    public List<Pelicula> findBySagaIgnoreCase(@PathVariable("saga") String saga) {
        return this.peliculaService.findBySagaIgnoreCase(saga);
    }

    @GetMapping("/peliculas/genero/{nombre}")
    public List<Pelicula> findByGenerosNombreIgnoreCase(@PathVariable("nombre") String nombre) {
        return this.peliculaService.findByGenerosNombreIgnoreCase(nombre);
    }

    @GetMapping("/peliculas/actor/{actor}")
    public List<Pelicula> findByActoresIgnoreCase(@PathVariable("actor") String actor) {
        return this.peliculaService.findByActoresIgnoreCase(actor);
    }

    @PostMapping("/peliculas")
    public Pelicula save(@RequestBody Pelicula pelicula) {
        return this.peliculaService.save(pelicula);
    }

    @PutMapping("/peliculas")
    public Pelicula update(@RequestBody Pelicula pelicula) {
        return this.peliculaService.update(pelicula);
    }

    @DeleteMapping("/peliculas/id/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        this.peliculaService.deleteById(id);
    }

    @GetMapping("/peliculas/add/actor/{id}/{nombre}")
    public void addActor(@PathVariable("id") Integer id, @PathVariable("nombre") String nombre) {
        this.peliculaService.addActor(id, nombre);
    }

    @GetMapping("/peliculas/delete/actor/{id}/{nombre}")
    public void deleteActor(@PathVariable("id") Integer id, @PathVariable("nombre") String nombre) {
        this.peliculaService.deleteActor(id, nombre);
    }

    @GetMapping("/peliculas/add/genero/{id}/{nombre}")
    public void addGenero(@PathVariable("id") Integer id, @PathVariable("nombre") String nombre) {
        this.peliculaService.addGenero(id, nombre);
    }

    @GetMapping("/peliculas/delete/genero/{id}/{nombre}")
    public void deleteGenero(@PathVariable("id") Integer id, @PathVariable("nombre") String nombre) {
        this.peliculaService.deleteGenero(id, nombre);
    }
}
