package es.uah.filmAffinity.service.genero;

import es.uah.filmAffinity.dao.genero.IGeneroDAO;
import es.uah.filmAffinity.dto.request.genero.GeneroRequest;
import es.uah.filmAffinity.dto.response.genero.GeneroResponse;
import es.uah.filmAffinity.mapper.genero.IGeneroMapper;
import es.uah.filmAffinity.model.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements IGeneroService {
    private final IGeneroDAO generoDAO;
    private final IGeneroMapper generoMapper;

    @Autowired
    public GeneroService(IGeneroDAO generoDAO, IGeneroMapper generoMapper) {
        this.generoDAO = generoDAO;
        this.generoMapper = generoMapper;
    }

    @Override
    public List<GeneroResponse> getGeneros() {
        return this.generoDAO.findAll().stream().map(this.generoMapper::toResponse).toList();
    }

    @Override
    public GeneroResponse getGeneroById(Integer id) {
        GeneroResponse response = null;
        if (id != null && id > 0) {
            response = this.generoMapper.toResponse(this.generoDAO.findById(id));
        }
        return response;
    }

    @Override
    public GeneroResponse createGenero(GeneroRequest genero) {
        GeneroResponse response = null;
        if (genero != null) {
            response = this.generoMapper.toResponse(this.generoDAO.save(this.generoMapper.toNewEntity(genero)));
        }
        return response;
    }

    @Override
    public GeneroResponse updateGenero(GeneroRequest genero) {
        GeneroResponse response = null;
        if (genero != null && genero.getId() != null && genero.getId() > 0) {
            Genero aux = this.generoDAO.findById(genero.getId());
            if (aux != null) {
                this.generoMapper.toUpdateEntity(genero, aux);
                this.generoDAO.update(aux);
                response = this.generoMapper.toResponse(aux);
            }
        }
        return response;
    }

    @Override
    public void deleteGeneroById(Integer id) {
        if (id != null && id > 0) {
            this.generoDAO.deleteById(id);
        }
    }
}
