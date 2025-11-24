package es.uah.filmAffinity.dao.genero;

import es.uah.filmAffinity.model.Genero;

import java.util.List;

public interface IGeneroDAO {
    List<Genero> findAll();
    Genero findById(Integer id);
    Genero findByNombreIgnoreCase(String nombre);
    Genero save(Genero genero);
    Genero update(Genero genero);
    void deleteById(Integer id);
}
