package es.uah.filmAffinity.service.actor;

import es.uah.filmAffinity.dao.actor.IActorDAO;
import es.uah.filmAffinity.dto.request.actor.ActorRequest;
import es.uah.filmAffinity.dto.response.actor.ActorResponse;
import es.uah.filmAffinity.mapper.actor.IActorMapper;
import es.uah.filmAffinity.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {
    private final IActorDAO actorDAO;
    private final IActorMapper actorMapper;

    @Autowired
    public ActorService(IActorDAO actorDAO, IActorMapper actorMapper) {
        this.actorDAO = actorDAO;
        this.actorMapper = actorMapper;
    }

    @Override
    public List<ActorResponse> findAll() {
        return this.actorDAO.findAll().stream().map(this.actorMapper::toResponse).toList();
    }

    @Override
    public ActorResponse findById(Integer id) {
        ActorResponse actor = null;
        if (id != null && id > 0) {
            actor = this.actorMapper.toResponse(this.actorDAO.findById(id));
        }
        return actor;
    }

    @Override
    public ActorResponse save(ActorRequest actor) {
        ActorResponse savedActor = null;
        if (actor != null) {
            savedActor = this.actorMapper.toResponse(this.actorDAO.save(this.actorMapper.toNewEntity(actor)));
        }
        return savedActor;
    }

    @Override
    public ActorResponse update(ActorRequest actor) {
        ActorResponse updatedActor = null;
        if (actor != null && actor.getId() != null && actor.getId() > 0) {
            Actor aux = this.actorDAO.findById(actor.getId());
            if (aux != null) {
                this.actorMapper.toUpdateEntity(actor, aux);
                aux = this.actorDAO.update(aux);
                updatedActor = this.actorMapper.toResponse(this.actorDAO.update(aux));
            }
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
