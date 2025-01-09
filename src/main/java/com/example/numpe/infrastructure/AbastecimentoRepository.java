package com.example.numpe.infrastructure;
import com.example.numpe.domain.entity.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/* Criação do repository com o JPA podemos utilizar função que fazem o mapeamento direto para a coluna informada seguindo
   o padrão camelCase */
@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {
    List<Abastecimento> findByPlaca(String placa);

    @Query("SELECT a FROM Abastecimento a WHERE a.placa = :placa ORDER BY a.dhAbastecimento DESC limit 1")
    Abastecimento findUltimoPorPlaca(String placa);
}
