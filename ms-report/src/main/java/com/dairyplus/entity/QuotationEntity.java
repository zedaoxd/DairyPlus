package com.dairyplus.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "quotations")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class QuotationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @Column(name = "create_at")
    @Setter(lombok.AccessLevel.NONE)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }
}
