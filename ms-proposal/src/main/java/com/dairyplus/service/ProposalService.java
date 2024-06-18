package com.dairyplus.service;

import com.dairyplus.dto.ProposalDetailsDTO;

import java.util.List;
import java.util.UUID;

public interface ProposalService {

    ProposalDetailsDTO findFullProposalById(UUID id);

    List<ProposalDetailsDTO> findAllProposals();

    void createProposal(ProposalDetailsDTO proposalDetailsDTO);

    void removeProposal(UUID id);
}
