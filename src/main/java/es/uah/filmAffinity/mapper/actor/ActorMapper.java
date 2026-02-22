package es.uah.filmAffinity.mapper.actor;

import es.uah.filmAffinity.dto.request.actor.ActorRequest;
import es.uah.filmAffinity.dto.response.actor.ActorResponse;
import es.uah.filmAffinity.dto.response.actor.ActorResponseMin;
import es.uah.filmAffinity.model.Actor;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

@Component
public class ActorMapper implements IActorMapper {
    @Override
    public Actor toNewEntity(ActorRequest actor) {
        Actor newActor = new Actor();
        newActor.setId(null);
        newActor.setNombre(actor.getNombre());
        newActor.setFechaNacimiento(actor.getFechaNacimiento());
        newActor.setPaisNacimiento(actor.getPaisNacimiento());
        newActor.setPeliculas(new LinkedHashSet<>());
        return newActor;
    }

    @Override
    public void toUpdateEntity(ActorRequest actor, Actor existingActor) {
        existingActor.setNombre(actor.getNombre());
        existingActor.setFechaNacimiento(actor.getFechaNacimiento());
        existingActor.setPaisNacimiento(actor.getPaisNacimiento());
    }

    @Override
    public ActorResponse toResponse(Actor actor) {
        return new ActorResponse(
                actor.getId(),
                actor.getNombre(),
                actor.getFechaNacimiento(),
                actor.getPaisNacimiento()
        );
    }

    @Override
    public ActorResponseMin toResponseMin(Actor actor) {
        return new ActorResponseMin(actor.getId(), actor.getNombre());
    }
}
