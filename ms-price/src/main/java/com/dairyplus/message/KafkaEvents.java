package com.dairyplus.message;

import com.dairyplus.dto.QuotationDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaEvents {
    private final Logger LOG = LoggerFactory.getLogger(KafkaEvents.class);

    @Channel("quotation-channel")
    Emitter<QuotationDTO> quotationEmitter;

    public void sendNewKafkaEvent(QuotationDTO quotationDTO) {
        LOG.info("Quotation sent to Kafka: {}", quotationDTO);
        quotationEmitter.send(quotationDTO).toCompletableFuture().join();
    }
}
