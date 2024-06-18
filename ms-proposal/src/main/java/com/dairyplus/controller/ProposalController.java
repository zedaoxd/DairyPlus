package com.dairyplus.controller;

import com.dairyplus.dto.ProposalDetailsDTO;
import com.dairyplus.service.ProposalService;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/proposals")
@Authenticated
@Slf4j
public class ProposalController {

    @Inject
    ProposalService proposalService;

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("/{id}")
    @RolesAllowed({ "manager", "user" })
    public Response getProposal(@PathParam("id") UUID id) {
        return Response.ok(proposalService.findFullProposalById(id)).build();
    }

    @GET
    @RolesAllowed({ "manager", "user" })
    public Response getProposals() {
        return Response.ok(proposalService.findAllProposals()).build();
    }

    @POST
    @RolesAllowed("proposal:write")
    public Response createProposal(ProposalDetailsDTO dto) {
        log.info("Received proposal creation request: {}", dto);
        proposalService.createProposal(dto);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("manager")
    public Response deleteProposal(@PathParam("id") UUID id) {
        proposalService.removeProposal(id);
        return Response.noContent().build();
    }
}
