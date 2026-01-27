package es.uah.filmAffinity.controller;

import es.uah.filmAffinity.model.Actor;
import es.uah.filmAffinity.service.actor.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {
    private IActorService actorService;

    @Autowired
    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actores")
    public List<Actor> findAll(){
        return this.actorService.findAll();
    }

    @GetMapping("/actores/id/{id}")
    public Actor findById(@PathVariable("id") Integer id){
        return this.actorService.findById(id);
    }

    @PostMapping("/actores")
    public Actor save(@RequestBody Actor actor){
        return this.actorService.save(actor);
    }

    @PutMapping("/actores")
    public Actor update(@RequestBody Actor actor){
        return this.actorService.update(actor);
    }

    @DeleteMapping("/actores/id/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        this.actorService.deleteById(id);
    }
}
