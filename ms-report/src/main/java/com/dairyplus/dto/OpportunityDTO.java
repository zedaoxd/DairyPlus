package com.dairyplus.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.UUID;

@Jacksonized
@Builder
public record OpportunityDTO(UUID proposalId,
                             String customer,
                             BigDecimal gallonPrice,
                             BigDecimal currentPrice) {
}
