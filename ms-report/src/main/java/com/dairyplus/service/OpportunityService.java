package com.dairyplus.service;

import com.dairyplus.dto.OpportunityDTO;
import com.dairyplus.dto.ProposalDTO;
import com.dairyplus.dto.QuotatioDTO;

import java.util.List;

public interface OpportunityService {
    void buildOpportunity(ProposalDTO dto);

    void saveQuotation(QuotatioDTO dto);

    List<OpportunityDTO> generateOpportunity();
}
