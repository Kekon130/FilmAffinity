package es.uah.filmAffinity.mapper.actor;

import es.uah.filmAffinity.dto.request.actor.ActorRequest;
import es.uah.filmAffinity.dto.response.actor.ActorResponse;
import es.uah.filmAffinity.dto.response.actor.ActorResponseMin;
import es.uah.filmAffinity.model.Actor;

public interface IActorMapper {
    Actor toNewEntity(ActorRequest actor);
    void toUpdateEntity(ActorRequest actor, Actor existingActor);
    ActorResponse toResponse(Actor actor);
    ActorResponseMin toResponseMin(Actor actor);
}
