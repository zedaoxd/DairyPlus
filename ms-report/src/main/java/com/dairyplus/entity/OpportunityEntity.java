package com.dairyplus.entity;

import com.dairyplus.dto.OpportunityDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "opportunities")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OpportunityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "proposal_id")
    private UUID proposalId;

    private String customer;

    @Column(name = "gallon_price")
    private BigDecimal gallonPrice;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @Column(name = "create_at")
    @Setter(lombok.AccessLevel.NONE)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    public OpportunityDTO toDTO() {
        return OpportunityDTO.builder()
                .proposalId(proposalId)
                .customer(customer)
                .gallonPrice(gallonPrice)
                .currentPrice(currentPrice)
                .build();
    }
}
