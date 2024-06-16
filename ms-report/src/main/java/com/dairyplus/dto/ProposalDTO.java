package com.dairyplus.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.UUID;

@Jacksonized
@Builder
public record ProposalDTO(UUID id,
                          String customer,
                          BigDecimal gallonPrice) {
}
