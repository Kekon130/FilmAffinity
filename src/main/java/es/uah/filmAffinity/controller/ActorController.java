package es.uah.filmAffinity.controller;

import es.uah.filmAffinity.dto.request.actor.ActorRequest;
import es.uah.filmAffinity.dto.response.actor.ActorResponse;
import es.uah.filmAffinity.service.actor.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {
    private final IActorService actorService;

    @Autowired
    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public List<ActorResponse> findAll() {
        return this.actorService.findAll();
    }

    @GetMapping("/actors/id/{id}")
    public ActorResponse findById(@PathVariable("id") Integer id) {
        return this.actorService.findById(id);
    }

    @PostMapping("/actors")
    public ActorResponse save(@RequestBody ActorRequest actor) {
        return this.actorService.save(actor);
    }

    @PutMapping("/actors")
    public ActorResponse update(@RequestBody ActorRequest actor) {
        return this.actorService.update(actor);
    }

    @DeleteMapping("/actors/id/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        this.actorService.deleteById(id);
    }
}
