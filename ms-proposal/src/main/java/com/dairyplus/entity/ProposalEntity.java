package com.dairyplus.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "proposals")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProposalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String customer;

    @Column(name = "gallon_price")
    private BigDecimal gallonPrice;

    private Integer gallons;

    private String country;

    @Column(name = "proposal_validity_days")
    private Integer proposalValidityDays;

    @Column(name = "created_at")
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }
}
