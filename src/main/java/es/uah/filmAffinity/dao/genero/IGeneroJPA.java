package es.uah.filmAffinity.dao.genero;

import es.uah.filmAffinity.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IGeneroJPA extends JpaRepository<Genero, Integer> {
    Optional<Genero> findByNombreIgnoreCase(String nombre);
}