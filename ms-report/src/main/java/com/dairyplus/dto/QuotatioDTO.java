package com.dairyplus.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.Date;

@Jacksonized
@Builder
public record QuotatioDTO(Date date,
                           BigDecimal currentPrice) {
}
