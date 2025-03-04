package es.santander.ascender.ejerc_006.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc_006.model.Aula;
import es.santander.ascender.ejerc_006.repository.AulaRepository;

@Service
@Transactional
public class AulaService {

    @Autowired
    private AulaRepository repository;

    public Aula create(Aula aula) {
        if (aula.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro columna creándolo",
                    CRUDOperation.CREATE,
                    aula.getId());
        }
        return repository.save(aula);
    }

    @Transactional(readOnly = true)
    public Aula read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Aula> read() {
        return repository.findAll();
    }

    public Aula update(Aula aula) {
        if (aula.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro columna modificándolo",
                    CRUDOperation.UPDATE,
                    null);

        }
        return repository.save(aula);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }

}
