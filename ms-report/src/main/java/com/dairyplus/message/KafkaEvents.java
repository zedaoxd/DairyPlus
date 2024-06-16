package com.dairyplus.message;

import com.dairyplus.dto.ProposalDTO;
import com.dairyplus.dto.QuotatioDTO;
import com.dairyplus.service.OpportunityService;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Slf4j
@ApplicationScoped
public class KafkaEvents {

    @Inject
    OpportunityService opportunityService;

    @Incoming("proposal")
    public void receiveProposal(ProposalDTO dto) {
        log.info("Received proposal: {}", dto);
        opportunityService.buildOpportunity(dto);
    }

    @Incoming("quotation")
    @Blocking
    public void receiveQuotation(QuotatioDTO dto) {
        log.info("Received quotation: {}", dto);
        opportunityService.saveQuotation(dto);
    }
}
