package es.uah.filmAffinity.dao.actor;

import es.uah.filmAffinity.model.Actor;

import java.util.List;

public interface IActorDAO {
    List<Actor> findAll();
    Actor findById(Integer id);
    Actor findByNombreIgnoreCase(String nombre);
    Actor save(Actor actor);
    Actor update(Actor actor);
    void deleteById(Integer id);
}
