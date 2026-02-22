package es.uah.filmAffinity.controller;

import es.uah.filmAffinity.dto.request.genero.GeneroRequest;
import es.uah.filmAffinity.dto.response.genero.GeneroResponse;
import es.uah.filmAffinity.service.genero.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeneroController {
    private final IGeneroService generoService;

    @Autowired
    public GeneroController(IGeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping("/genres")
    public List<GeneroResponse> getGeneros() {
        return this.generoService.getGeneros();
    }

    @GetMapping("/genres/id/{id}")
    public GeneroResponse getGeneroById(@PathVariable("id") Integer id) {
        return this.generoService.getGeneroById(id);
    }

    @PostMapping("/genres")
    public GeneroResponse createGenero(@RequestBody GeneroRequest genero) {
        return this.generoService.createGenero(genero);
    }

    @PutMapping("/genres")
    public GeneroResponse updateGenero(@RequestBody GeneroRequest genero) {
        return this.generoService.updateGenero(genero);
    }

    @DeleteMapping("/genres/id/{id}")
    public void deleteGeneroById(@PathVariable("id") Integer id) {
        this.generoService.deleteGeneroById(id);
    }

}
