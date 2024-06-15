package com.dairyplus.service;

import com.dairyplus.dto.ProposalDTO;
import com.dairyplus.dto.ProposalDetailsDTO;
import com.dairyplus.entity.ProposalEntity;
import com.dairyplus.message.KafkaEvents;
import com.dairyplus.repository.ProposalRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

    @Inject
    ProposalRepository proposalRepository;

    @Inject
    KafkaEvents kafkaEvents;

    @Override
    public ProposalDetailsDTO findFullProposalById(UUID id) {
        var entity = proposalRepository.findById(id);
        return ProposalDetailsDTO.builder()
                .id(entity.getId())
                .customer(entity.getCustomer())
                .gallonPrice(entity.getGallonPrice())
                .gallons(entity.getGallons())
                .country(entity.getCountry())
                .proposalValidityDays(entity.getProposalValidityDays())
                .build();
    }

    @Override
    @Transactional
    public void createProposal(ProposalDetailsDTO proposalDetailsDTO) {
        var entity = new ProposalEntity();
        entity.setCustomer(proposalDetailsDTO.customer());
        entity.setGallonPrice(proposalDetailsDTO.gallonPrice());
        entity.setGallons(proposalDetailsDTO.gallons());
        entity.setCountry(proposalDetailsDTO.country());
        entity.setProposalValidityDays(proposalDetailsDTO.proposalValidityDays());
        proposalRepository.persist(entity);

        var proposalDTO = ProposalDTO.builder()
                .id(proposalRepository.findIdByCustomer(proposalDetailsDTO.customer()))
                .customer(proposalDetailsDTO.customer())
                .gallonPrice(proposalDetailsDTO.gallonPrice())
                .build();

        kafkaEvents.sendProposalCreatedEvent(proposalDTO);
    }

    @Override
    @Transactional
    public void removeProposal(UUID id) {
        proposalRepository.deleteById(id);
    }
}
