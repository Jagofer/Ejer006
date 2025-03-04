package es.santander.ascender.ejerc_006.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc_006.model.Aula;
import es.santander.ascender.ejerc_006.model.Mesa;
import es.santander.ascender.ejerc_006.repository.AulaRepository;
import es.santander.ascender.ejerc_006.repository.MesaRepository;

@Service
@Transactional
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private AulaRepository aulaRepository;

    public Mesa create(Mesa mesa) {
        if (mesa.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro columna creándolo",
                    CRUDOperation.CREATE,
                    mesa.getId());
        }
        return mesaRepository.save(mesa);
    }

    @Transactional(readOnly = true)
    public Mesa read(Long id) {
        return mesaRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Mesa> read() {
        return mesaRepository.findAll();
    }

    public Mesa update(Mesa mesa) {
        if (mesa.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro columna modificándolo",
                    CRUDOperation.UPDATE,
                    null);

        }
        return mesaRepository.save(mesa);
    }

    public void delete(Long id) {
        mesaRepository.deleteById(id);
        return;
    }

    public void moverMesa(Long mesaId, Long nuevaAulaId) {
        Mesa mesa = mesaRepository.findById(mesaId)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado la mesa"));

        Aula nuevaAula = aulaRepository.findById(nuevaAulaId)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado el aula"));

        mesa.setAula(nuevaAula);  // Cambiar el aula de la mesa
        mesaRepository.save(mesa);
    }

}
