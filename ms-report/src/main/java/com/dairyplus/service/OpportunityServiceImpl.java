package com.dairyplus.service;

import com.dairyplus.dto.OpportunityDTO;
import com.dairyplus.dto.ProposalDTO;
import com.dairyplus.dto.QuotatioDTO;
import com.dairyplus.entity.OpportunityEntity;
import com.dairyplus.entity.QuotationEntity;
import com.dairyplus.repository.OpportunityRepository;
import com.dairyplus.repository.QuotationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class OpportunityServiceImpl implements OpportunityService {
    @Inject
    QuotationRepository quotationRepository;

    @Inject
    OpportunityRepository opportunityRepository;

    @Override
    @Transactional
    public void buildOpportunity(ProposalDTO dto) {
        var quotation = quotationRepository.findLatestQuotation();

        var opportunity = new OpportunityEntity();
        opportunity.setProposalId(dto.id());
        opportunity.setCustomer(dto.customer());
        opportunity.setGallonPrice(dto.gallonPrice());
        opportunity.setCurrentPrice(quotation.getCurrentPrice());

        opportunityRepository.persist(opportunity);
    }

    @Override
    @Transactional
    public void saveQuotation(QuotatioDTO dto) {
        var quotation = new QuotationEntity();
        quotation.setCurrentPrice(dto.currentPrice());
        quotationRepository.persist(quotation);
    }

    @Override
    public List<OpportunityDTO> generateOpportunity() {
        return opportunityRepository
                .listAll()
                .stream()
                .map(OpportunityEntity::toDTO)
                .toList();
    }
}
