package com.dairyplus.service;

import java.util.UUID;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.dairyplus.client.ProposalRestClient;
import com.dairyplus.dto.ProposalDetailsDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

    @Inject
    @RestClient
    ProposalRestClient proposalRestClient;

    @Override
    public Response getProposalDetailsById(UUID id) {
        return proposalRestClient.getProposalDetailsById(id);
    }

    @Override
    public Response getProposals() {
        return proposalRestClient.getProposals();
    }

    @Override
    public Response createProposal(ProposalDetailsDTO proposalDetailsDTO) {
        return proposalRestClient.createProposal(proposalDetailsDTO);
    }

    @Override
    public Response removeProposal(UUID id) {
        return proposalRestClient.removeProposal(id);
    }
}
