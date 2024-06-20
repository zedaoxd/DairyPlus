package com.dairyplus.service;

import com.dairyplus.dto.ProposalDetailsDTO;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

public interface ProposalService {

    Response getProposalDetailsById(UUID id);

    Response getProposals();

    Response createProposal(ProposalDetailsDTO proposalDetailsDTO);

    Response removeProposal(UUID id);
}
