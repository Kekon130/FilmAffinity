package es.uah.filmAffinity.dao.actor;

import es.uah.filmAffinity.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorDAO implements IActorDAO {
    private IActorJPA actorJPA;

    @Autowired
    public ActorDAO(IActorJPA actorJPA) {
        this.actorJPA = actorJPA;
    }

    @Override
    public List<Actor> findAll() {
        return this.actorJPA.findAll();
    }

    @Override
    public Actor findById(Integer id) {
        return this.actorJPA.findById(id).orElse(null);
    }

    @Override
    public Actor findByNombreIgnoreCase(String nombre) {
        return  this.actorJPA.findByNombreIgnoreCase(nombre).orElse(null);
    }

    @Override
    public Actor save(Actor actor) {
        Actor savedActor = null;
        if (actor != null) {
            savedActor = this.actorJPA.save(actor);
        }
        return savedActor;
    }

    @Override
    public Actor update(Actor actor) {
        Actor updatedActor = null;
        if (actor != null && this.actorJPA.existsById(actor.getId())) {
            updatedActor = this.actorJPA.save(actor);
        }
        return updatedActor;
    }

    @Override
    public void deleteById(Integer id) {
        if (this.actorJPA.existsById(id)) {
            this.actorJPA.deleteById(id);
        }
    }
}
