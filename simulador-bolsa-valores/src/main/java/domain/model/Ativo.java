package domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ativos")
public class Ativo {

    @Id
    private String id;

    private String codigo;

    private String nome;

    @Column(name = "preco_inicial", precision = 10, scale = 2)
    private BigDecimal precoInicial;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;
}
