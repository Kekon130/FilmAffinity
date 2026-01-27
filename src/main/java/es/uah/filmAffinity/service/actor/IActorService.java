package es.uah.filmAffinity.service.actor;

import es.uah.filmAffinity.model.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> findAll();
    Actor findById(Integer id);
    Actor save(Actor actor);
    Actor update(Actor actor);
    void deleteById(Integer id);
}
