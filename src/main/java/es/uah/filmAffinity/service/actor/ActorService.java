package es.uah.filmAffinity.service.actor;

import es.uah.filmAffinity.dao.actor.IActorDAO;
import es.uah.filmAffinity.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {
    private IActorDAO actorDAO;

    @Autowired
    public ActorService(IActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }

    @Override
    public List<Actor> findAll() {
        return this.actorDAO.findAll();
    }

    @Override
    public Actor findById(Integer id) {
        Actor actor = null;
        if (id != null && id > 0) {
            actor = this.actorDAO.findById(id);
        }
        return actor;
    }

    @Override
    public Actor save(Actor actor) {
        Actor savedActor = null;
        if (actor != null && (actor.getId() == null || actor.getId() == 0)) {
            actor.setId(null);
            savedActor = this.actorDAO.save(actor);
        }
        return savedActor;
    }

    @Override
    public Actor update(Actor actor) {
        Actor updatedActor = null;
        if (actor != null && actor.getId() != null && actor.getId() > 0) {
            updatedActor = this.actorDAO.update(actor);
        }
        return updatedActor;
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && id > 0) {
            this.actorDAO.deleteById(id);
        }
    }
}
