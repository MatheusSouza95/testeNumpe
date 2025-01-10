package com.example.numpe.application;

import com.example.numpe.domain.entity.Abastecimento;
import com.example.numpe.infrastructure.AbastecimentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AbastecimentoServiceTest {

    private AbastecimentoRepository repository;
    private AbastecimentoService service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(AbastecimentoRepository.class);
        service = new AbastecimentoService(repository);
    }

    @Test
    void deveAdicionarAbastecimentoValido() {
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setPlaca("ABC-1234");
        abastecimento.setDhAbastecimento(LocalDateTime.now().minusDays(1));
        abastecimento.setVlTotal(50.0);
        abastecimento.setQuilometragem(1000);

        when(repository.save(abastecimento)).thenReturn(abastecimento);

        Abastecimento resultado = service.adicionarAbastecimento(abastecimento);

        assertNotNull(resultado);
        assertEquals("ABC-1234", resultado.getPlaca());
        verify(repository, times(1)).save(abastecimento);
    }

    @Test
    void deveLancarExcecaoQuandoDataNoFuturo() {
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setDhAbastecimento(LocalDateTime.now().plusDays(1));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.adicionarAbastecimento(abastecimento));

        assertEquals("A data e hora não podem ser no futuro.", exception.getMessage());
        verify(repository, never()).save(any());
    }

    @Test
    void deveRemoverAbastecimento() {
        Long id = 1L;
        service.removerAbastecimento(id);
        verify(repository, times(1)).deleteById(id);
    }
}
