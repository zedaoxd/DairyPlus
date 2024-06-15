package com.dairyplus.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "quotations")
@Data
@NoArgsConstructor
public class QuotationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Date date;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @Column(name = "percentage_change")
    private String pctChange;

    private String pair;
}
