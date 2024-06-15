package com.dairyplus.client;

import com.dairyplus.dto.CurrentPriceDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/last")
@RegisterRestClient
@ApplicationScoped
public interface CurrentPriceClient {

    @GET
    @Path("/{pair}")
    CurrentPriceDTO getCurrentPrice(@PathParam("pair") String pair);
}
