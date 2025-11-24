package es.uah.filmAffinity.controller;

import es.uah.filmAffinity.model.Genero;
import es.uah.filmAffinity.service.genero.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeneroController {
    private IGeneroService generoService;

    @Autowired
    public GeneroController(IGeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping("/generos")
    public List<Genero> getGeneros(){
        return this.generoService.getGeneros();
    }

    @GetMapping("/generos/id/{id}")
    public Genero getGeneroById(@PathVariable("id") Integer id){
        return this.generoService.getGeneroById(id);
    }

    @GetMapping("/generos/nombre/{nombre}")
    public Genero getGeneroByNombre(@PathVariable("nombre") String nombre){
        return this.generoService.getGeneroByNombreIgnoreCase(nombre);
    }

    @PostMapping("/generos")
    public Genero createGenero(@RequestBody Genero genero){
        return this.generoService.createGenero(genero);
    }

    @PutMapping("/generos")
    public Genero updateGenero(@RequestBody Genero genero){
        return this.generoService.updateGenero(genero);
    }

    @DeleteMapping("/generos/id/{id}")
    public void deleteGeneroById(@PathVariable("id") Integer id){
        this.generoService.deleteGeneroById(id);
    }

}
