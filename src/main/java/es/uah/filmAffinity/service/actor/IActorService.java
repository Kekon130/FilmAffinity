package es.uah.filmAffinity.service.actor;

import es.uah.filmAffinity.dto.request.actor.ActorRequest;
import es.uah.filmAffinity.dto.response.actor.ActorResponse;

import java.util.List;

public interface IActorService {
    List<ActorResponse> findAll();
    ActorResponse findById(Integer id);
    ActorResponse save(ActorRequest actor);
    ActorResponse update(ActorRequest actor);
    void deleteById(Integer id);
}
