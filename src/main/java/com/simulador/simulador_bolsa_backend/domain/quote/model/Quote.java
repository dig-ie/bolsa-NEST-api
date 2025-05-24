package com.simulador.simulador_bolsa_backend.domain.quote.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "quotes")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "asset_id", nullable = false)
    private Long assetId;

    @Column(name = "price", nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    @Column(name = "timestamp", nullable = false, updatable = false)
    private LocalDateTime timestamp = LocalDateTime.now();


    public Quote(Long assetId, BigDecimal price) {
        this.assetId = Objects.requireNonNull(assetId, "Asset ID cannot be null");
        this.price = Objects.requireNonNull(price, "Price cannot be null");
    }

    public boolean isPricePositive() {
        return price.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Quote quote)) return false;
        return Objects.equals(id, quote.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}


