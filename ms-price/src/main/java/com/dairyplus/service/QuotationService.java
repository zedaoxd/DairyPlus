package com.dairyplus.service;

import com.dairyplus.client.CurrentPriceClient;
import com.dairyplus.dto.CurrentPriceDTO;
import com.dairyplus.dto.QuotationDTO;
import com.dairyplus.entity.QuotationEntity;
import com.dairyplus.message.KafkaEvents;
import com.dairyplus.repository.QuotationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.util.Date;

@ApplicationScoped
public class QuotationService {

    @RestClient
    @Inject
    CurrentPriceClient currentPriceClient;

    @Inject
    QuotationRepository quotationRepository;

    @Inject
    KafkaEvents kafkaEvents;

    public void getCurrentPrice() {
        var dto = currentPriceClient.getCurrentPrice("USD-BRL");

        if (updateCurrentInfoPrice(dto)) {
            kafkaEvents.sendNewKafkaEvent(QuotationDTO
                    .builder()
                    .currentPrice(new BigDecimal(dto.usdbrl().bid()))
                    .date(new Date())
                    .build());
        }
    }

    public void cleanDatabase() {
        quotationRepository.deleteAll();
    }

    private boolean updateCurrentInfoPrice(CurrentPriceDTO dto) {
        var quotation = quotationRepository.getLastQuotation();

        if (quotation == null) {
            saveQuotation(dto);
            return true;
        } else {
            var currentPrice = new BigDecimal(dto.usdbrl().bid());

            if (currentPrice.compareTo(quotation.getCurrentPrice()) != 0) {
                saveQuotation(dto);
                return true;
            }
        }

        return false;
    }

    private void saveQuotation(CurrentPriceDTO dto) {
        var quotation = new QuotationEntity();

        quotation.setDate(new Date());
        quotation.setCurrentPrice(new BigDecimal(dto.usdbrl().bid()));
        quotation.setPctChange(dto.usdbrl().pctChange());
        quotation.setPair("USD-BRL");

        quotationRepository.persist(quotation);
    }
}
