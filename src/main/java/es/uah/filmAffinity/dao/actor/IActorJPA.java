package es.uah.filmAffinity.dao.actor;

import es.uah.filmAffinity.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IActorJPA extends JpaRepository<Actor, Integer> {
    Optional<Actor> findByNombreIgnoreCase(String nombre);
}