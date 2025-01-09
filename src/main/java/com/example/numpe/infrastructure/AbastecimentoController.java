package com.example.numpe.infrastructure;

import com.example.numpe.application.AbastecimentoService;
import com.example.numpe.domain.entity.Abastecimento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/* Controller com endpoints relacionados ao abastecimento */
@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {

    private final AbastecimentoService service;

    public AbastecimentoController(AbastecimentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Abastecimento> listar(@RequestParam(required = false) String placa) {
        return service.listarAbastecimentos(placa);
    }

    @GetMapping("/{id}")
    public Abastecimento listarPorId(@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Abastecimento> adicionar(@RequestBody Abastecimento abastecimento) {
        return ResponseEntity.ok(service.adicionarAbastecimento(abastecimento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.removerAbastecimento(id);
        return ResponseEntity.noContent().build();
    }
}