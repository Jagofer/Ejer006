package es.santander.ascender.ejerc_006.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.santander.ascender.ejerc_006.model.Aula;
import es.santander.ascender.ejerc_006.repository.AulaRepository;

@ExtendWith(MockitoExtension.class)
public class AulaServiceTest {

    @Mock
    private AulaRepository aulaRepository;

    @InjectMocks
    private AulaService aulaService;

    private Aula aula;

    @BeforeEach
    void setUp() {
        aula = new Aula();
        aula.setId(1L);
        aula.setNombre("Aula 101");
    }

    @Test
void testCreateAula() {
    Aula newAula = new Aula(); // ✅ Crear un aula sin ID
    newAula.setNombre("Aula 101");

    when(aulaRepository.save(any(Aula.class))).thenReturn(newAula);
    Aula created = aulaService.create(newAula);

    assertNotNull(created);
    assertEquals("Aula 101", created.getNombre());
}

    

    @Test
    void testReadAula() {
        when(aulaRepository.findById(1L)).thenReturn(Optional.of(aula));
        Aula found = aulaService.read(1L);
        assertNotNull(found);
        assertEquals(1L, found.getId());
    }

    @Test
    void testDeleteAula() {
        doNothing().when(aulaRepository).deleteById(1L);
        assertDoesNotThrow(() -> aulaService.delete(1L));
    }
}
