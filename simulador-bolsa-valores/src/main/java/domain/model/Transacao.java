package domain.model;

import jakarta.persistence.*;
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
@Table(name = "transacoes")
public class Transacao {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    @Column(name = "preco_unitario", precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    private int quantidade;

    @Column(precision = 12, scale = 2)
    private BigDecimal total;

    private LocalDateTime timestamp;

    public enum TipoTransacao {
        COMPRA,
        VENDA
    }
}