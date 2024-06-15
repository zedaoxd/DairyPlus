package com.dairyplus.controller;

import com.dairyplus.dto.ProposalDetailsDTO;
import com.dairyplus.service.ProposalService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Path("/api/proposals")
@Slf4j
public class ProposalController {

    @Inject
    ProposalService proposalService;

    @GET
    @Path("/{id}")
    public Response getProposal(@PathParam("id") UUID id) {
        return Response.ok(proposalService.findFullProposalById(id)).build();
    }

    @POST
    @RolesAllowed("proposal:create")
    public Response createProposal(ProposalDetailsDTO dto) {
        log.info("Received proposal creation request: {}", dto);
        proposalService.createProposal(dto);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("proposal:delete")
    public Response deleteProposal(@PathParam("id") UUID id) {
        proposalService.removeProposal(id);
        return Response.noContent().build();
    }
}
