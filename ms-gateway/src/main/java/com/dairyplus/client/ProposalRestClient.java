package com.dairyplus.client;

import java.util.UUID;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.dairyplus.dto.ProposalDetailsDTO;

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/proposals")
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@ApplicationScoped
public interface ProposalRestClient {

    @GET
    @Path("/{id}")
    Response getProposalDetailsById(@PathParam("id") UUID id);

    @GET
    Response getProposals();

    @POST
    Response createProposal(ProposalDetailsDTO proposalDetailsDTO);

    @DELETE
    @Path("/{id}")
    Response removeProposal(@PathParam("id") UUID id);
}
