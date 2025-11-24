package es.uah.filmAffinity.dao.genero;
import es.uah.filmAffinity.model.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GeneroDAO implements IGeneroDAO {
    private IGeneroJPA generoJPA;

    @Autowired
    public GeneroDAO(IGeneroJPA generoJPA) {
        this.generoJPA = generoJPA;
    }

    @Override
    public List<Genero> findAll() {
        return this.generoJPA.findAll();
    }

    @Override
    public Genero findById(Integer id) {
        return this.generoJPA.findById(id).orElse(null);
    }

    @Override
    public Genero findByNombreIgnoreCase(String nombre) {
        return Optional.ofNullable(this.generoJPA.findByNombreIgnoreCase(nombre)).orElse(null);
    }

    @Override
    public Genero save(Genero genero) {
        Genero savedGenero = null;
        if (genero != null) {
            savedGenero = this.generoJPA.save(genero);
        }
        return savedGenero;
    }

    @Override
    public Genero update(Genero genero) {
        Genero updatedGenero = null;
        if (genero != null && this.generoJPA.existsById(genero.getId())) {
            updatedGenero = this.generoJPA.save(genero);
        }
        return updatedGenero;
    }

    @Override
    public void deleteById(Integer id) {
        if (this.generoJPA.existsById(id)) {
            this.generoJPA.deleteById(id);
        }
    }
}
