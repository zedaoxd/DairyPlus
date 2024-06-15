package com.dairyplus.message;

import com.dairyplus.dto.ProposalDTO;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
@Slf4j
public class KafkaEvents {

    @Channel("proposal")
    Emitter<ProposalDTO> proposalDTOEmitter;

    public void sendProposalCreatedEvent(ProposalDTO proposalDTO) {
        log.info("Sending proposal to Kafka: {}", proposalDTO);
        proposalDTOEmitter.send(proposalDTO).toCompletableFuture().join();
    }
}
