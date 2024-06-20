package com.dairyplus.controller;

import java.util.UUID;

import com.dairyplus.dto.ProposalDetailsDTO;
import com.dairyplus.service.ProposalService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/trade")
public class ProposalController {

    @Inject
    ProposalService proposalService;

    @GET
    @Path("{id}")
    @RolesAllowed("proposal:read")
    public Response getProposalById(@PathParam("id") UUID id) {
        return proposalService.getProposalDetailsById(id);
    }

    @GET
    @RolesAllowed("proposal:read")
    public Response getProposals() {
        return proposalService.getProposals();
    }

    @POST
    @RolesAllowed("proposal:create")
    public Response createProposal(ProposalDetailsDTO proposalDetailsDTO) {
        return proposalService.createProposal(proposalDetailsDTO);
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed("proposal:delete")
    public Response removeProposal(@PathParam("id") UUID id) {
        return proposalService.removeProposal(id);
    }

}
