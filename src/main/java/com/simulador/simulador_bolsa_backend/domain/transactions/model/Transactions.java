package com.simulador.simulador_bolsa_backend.domain.transactions.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


public class Transactions {
    public enum Type {BUY, SELL}

    private final UUID id;
    private final UUID userId;
    private final UUID assentId;
    private final Type type;
    private final BigDecimal unitePrice;
    private final int quantity;
    private final BigDecimal total;
    private final LocalDateTime timestamp;

    private Transactions(Builder builder) {
        this.id = Objects.requireNonNull(builder.id);
        this.userId = Objects.requireNonNull(builder.userId);
        this.assentId = Objects.requireNonNull(builder.assentId);
        this.type = Objects.requireNonNull(builder.type);
        this.unitePrice = Objects.requireNonNull(builder.unitePrice);
        this.quantity = builder.quantity;
        this.total = Objects.requireNonNull(builder.total);
        this.timestamp = Objects.requireNonNull(builder.timestamp);
    }

    public static class Builder {
        private UUID id;
        private UUID userId;
        private UUID assentId;
        private Type type;
        private BigDecimal unitePrice;
        private int quantity;
        private BigDecimal total;
        private LocalDateTime timestamp;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder assentId(UUID assentId) {
            this.assentId = assentId;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder unitePrice(BigDecimal unitePrice) {
            this.unitePrice = unitePrice;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder total(BigDecimal total) {
            this.total = total;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Transactions build() {
            return new Transactions(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getAssentId() {
        return assentId;
    }

    public Type getType() {
        return type;
    }

    public BigDecimal getUnitePrice() {
        return unitePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}