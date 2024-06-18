package com.dairyplus.controller;

import org.eclipse.microprofile.jwt.JsonWebToken;

import com.dairyplus.service.OpportunityService;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/opportunities")
@Authenticated
public class OppotunityController {

    @Inject
    OpportunityService opportunityService;

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("/data")
    @RolesAllowed({ "manager", "user" })
    public Response generateOpportunity() {
        return Response.ok(opportunityService.generateOpportunity()).build();
    }
}
