package com.dairyplus.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.UUID;

@Jacksonized
@Builder
public record ProposalDetailsDTO(UUID id,
                                 String customer,
                                 BigDecimal gallonPrice,
                                 Integer gallons,
                                 String country,
                                 Integer proposalValidityDays) {
}
