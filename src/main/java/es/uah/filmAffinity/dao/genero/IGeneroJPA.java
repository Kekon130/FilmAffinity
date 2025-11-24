package es.uah.filmAffinity.dao.genero;

import es.uah.filmAffinity.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeneroJPA extends JpaRepository<Genero, Integer> {
    Genero findByNombreIgnoreCase(String nombre);
}