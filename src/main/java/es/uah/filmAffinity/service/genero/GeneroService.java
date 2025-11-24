package es.uah.filmAffinity.service.genero;

import es.uah.filmAffinity.dao.genero.IGeneroDAO;
import es.uah.filmAffinity.model.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements IGeneroService {
    private IGeneroDAO generoDAO;

    @Autowired
    public GeneroService(IGeneroDAO generoDAO) {
        this.generoDAO = generoDAO;
    }

    @Override
    public List<Genero> getGeneros() {
        return this.generoDAO.findAll();
    }

    @Override
    public Genero getGeneroById(Integer id) {
        Genero genero = null;
        if (id != null && id > 0) {
            genero = this.generoDAO.findById(id);
        }
        return genero;
    }

    @Override
    public Genero getGeneroByNombreIgnoreCase(String nombre) {
        Genero genero = null;
        if (nombre != null && !nombre.isEmpty()) {
            genero = this.generoDAO.findByNombreIgnoreCase(nombre);
        }
        return genero;
    }

    @Override
    public Genero createGenero(Genero genero) {
        Genero savedGenero = null;
        if (genero != null && (genero.getId() == null || genero.getId() == 0)) {
            genero.setId(null);
            savedGenero = this.generoDAO.save(genero);
        }
        return savedGenero;
    }

    @Override
    public Genero updateGenero(Genero genero) {
        Genero updatedGenero = null;
        if (genero != null && genero.getId() != null && genero.getId() > 0) {
            updatedGenero = this.generoDAO.update(genero);
        }
        return updatedGenero;
    }

    @Override
    public void deleteGeneroById(Integer id) {
        if (id != null && id > 0) {
            this.generoDAO.deleteById(id);
        }
    }
}
