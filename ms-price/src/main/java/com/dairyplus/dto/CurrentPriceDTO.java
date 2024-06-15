package com.dairyplus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record CurrentPriceDTO(@JsonProperty("USDBRL") USDBRL usdbrl) {
}
