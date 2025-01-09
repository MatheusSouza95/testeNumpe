package com.example.numpe.application;

import com.example.numpe.domain.entity.Abastecimento;
import com.example.numpe.infrastructure.AbastecimentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
/* Criação do service com todas as regras. */
@Service
public class AbastecimentoService {
    private final AbastecimentoRepository repository;

    public AbastecimentoService(AbastecimentoRepository repository) {
        this.repository = repository;
    }

    public List<Abastecimento> listarAbastecimentos(String placa) {
        if (placa != null && !placa.isEmpty()) {
            return repository.findByPlaca(placa);
        }
        return repository.findAll();
    }

    public Abastecimento listarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Abastecimento com ID " + id + " não encontrado."));
    }

    public Abastecimento adicionarAbastecimento(Abastecimento abastecimento) {
        validarAbastecimento(abastecimento);
        return repository.save(abastecimento);
    }

    public void removerAbastecimento(Long id) {
        repository.deleteById(id);
    }

    private void validarAbastecimento(Abastecimento abastecimento) {
        if (abastecimento.getDhAbastecimento().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data e hora não podem ser no futuro.");
        }
        if (!abastecimento.getPlaca().matches("[A-Z]{3}-\\d{4}|[A-Z]{3}\\d[A-Z]\\d{2}")) { // Uso do rejex para a trativa das duas regras de placa
            throw new IllegalArgumentException("A placa está em um formato inválido.");
        }
        if (abastecimento.getVlTotal() <= 0) {
            throw new IllegalArgumentException("O valor total deve ser maior que zero.");
        }
        if(abastecimento.getQuilometragem()<0){
            throw new IllegalArgumentException("O valor da quilometragem deve ser maior ou igual a zero.");
        }
        Abastecimento ultimoAbastecimento = repository.findUltimoPorPlaca(abastecimento.getPlaca());
        if (ultimoAbastecimento != null && abastecimento.getQuilometragem() <= ultimoAbastecimento.getQuilometragem()) {
            throw new IllegalArgumentException("A quilometragem deve ser maior que a do último abastecimento.");
        }

    }
}
