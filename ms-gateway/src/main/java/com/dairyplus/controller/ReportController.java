package com.dairyplus.controller;

import com.dairyplus.service.ReportService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/opportunities")
public class ReportController {

    @Inject
    ReportService reportService;

    @GET
    @Path("/data")
    @RolesAllowed("opportunities:read")
    public Response getOpportunitiesData() {
        return Response
                .ok(reportService.getOpportunitiesData(), MediaType.APPLICATION_JSON)
                .header("Content-Disposition", "attachment; filename=opportunities.csv")
                .build();
    }

    @GET
    @Path("/report")
    @RolesAllowed("opportunities:read")
    public Response generateCSVOpportunityReport() {
        return Response.ok(reportService.generateCSVOpportunityReport(), MediaType.APPLICATION_OCTET_STREAM).build();
    }
}
