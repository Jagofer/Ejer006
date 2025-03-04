
package es.santander.ascender.ejerc_006.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc_006.model.Aula;
import es.santander.ascender.ejerc_006.model.Edificio;
import es.santander.ascender.ejerc_006.model.Mesa;
import es.santander.ascender.ejerc_006.model.Silla;
import es.santander.ascender.ejerc_006.service.AulaService;
import es.santander.ascender.ejerc_006.service.EdificioService;
import es.santander.ascender.ejerc_006.service.MesaService;
import es.santander.ascender.ejerc_006.service.SillaService;

@ExtendWith(MockitoExtension.class)

@SpringBootTest(classes = es.santander.ascender.ejerc_006.Ejerc006Application.class)
public class ApplicationServiceTest {

    @Mock
    private AulaRepository aulaRepository;
    @Mock
    private EdificioRepository edificioRepository;
    @Mock
    private MesaRepository mesaRepository;
    @Mock
    private SillaRepository sillaRepository;

    @InjectMocks
    private AulaService aulaService;
    @InjectMocks
    private EdificioService edificioService;
    @InjectMocks
    private MesaService mesaService;
    @InjectMocks
    private SillaService sillaService;

    private Aula aula;
    private Edificio edificio;
    private Mesa mesa;
    private Silla silla;

    @BeforeEach
    void setUp() {
        aula = new Aula();
        aula.setId(1L);
        aula.setNombre("Aula 101");

        edificio = new Edificio();
        edificio.setId(1L);
        edificio.setNombre("Edificio Principal");

        mesa = new Mesa();
        mesa.setId(1L);
        mesa.setMaterialUno("Madera");

        silla = new Silla();
        silla.setId(1L);
        silla.setMaterialUno("Plástico");
    }

    @Test
    void testCreateAula() {
        aula.setId(null);
        when(aulaRepository.save(any(Aula.class))).thenReturn(aula);

        Aula createdAula = aulaService.create(aula);

        assertNotNull(createdAula);
        assertEquals("Aula 101", createdAula.getNombre());
        verify(aulaRepository, times(1)).save(any(Aula.class));
    }

    @Test
    void testCreateEdificio() {
        edificio.setId(null);
        when(edificioRepository.save(any(Edificio.class))).thenReturn(edificio);

        Edificio createdEdificio = edificioService.create(edificio);

        assertNotNull(createdEdificio);
        assertEquals("Edificio Principal", createdEdificio.getNombre());
        verify(edificioRepository, times(1)).save(any(Edificio.class));
    }
}
    