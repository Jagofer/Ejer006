package es.santander.ascender.ejerc_006.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AulaTest {

    private Aula aula;

    @BeforeEach
    void setUp() {
        aula = new Aula();
        aula.setId(1L);
        aula.setNombre("Aula 101");
    }

    @Test
    void testAulaAttributes() {
        assertEquals(1L, aula.getId());
        assertEquals("Aula 101", aula.getNombre());
    }

    @Test
    void testSetAulaAttributes() {
        aula.setId(2L);
        aula.setNombre("Aula 202");
        
        assertEquals(2L, aula.getId());
        assertEquals("Aula 202", aula.getNombre());
    }
}
