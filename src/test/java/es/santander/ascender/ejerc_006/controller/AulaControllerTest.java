package es.santander.ascender.ejerc_006.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import es.santander.ascender.ejerc_006.model.Aula;
import es.santander.ascender.ejerc_006.service.AulaService;

@WebMvcTest(AulaController.class)  
public class AulaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AulaService aulaService;

    private Aula aula;

    @BeforeEach
    void setUp() {
        aula = new Aula();
        aula.setId(1L);
        aula.setNombre("Aula 101");
    }

    @Test
    void testGetAulaById() throws Exception {
        when(aulaService.read(1L)).thenReturn(aula);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/aula/1")  
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
