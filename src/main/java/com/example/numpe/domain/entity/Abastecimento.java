package com.example.numpe.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
/* Mapeamento da tabela abastecimento */
@Entity
@Table(name = "abastecimentos")
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 8)
    private String placa;

    @Column(nullable = false)
    private int quilometragem;

    @Column(nullable = false)
    private double vlTotal;

    @Column(nullable = false)
    private LocalDateTime dhAbastecimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public LocalDateTime getDhAbastecimento() {
        return dhAbastecimento;
    }

    public void setDhAbastecimento(LocalDateTime dhAbastecimento) {
        this.dhAbastecimento = dhAbastecimento;
    }
}
