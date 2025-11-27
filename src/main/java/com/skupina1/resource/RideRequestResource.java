package com.skupina1.resource;

import com.skupina1.model.RideRequest;
import com.skupina1.persistence.RideRequestEntity;
import com.skupina1.service.RideRequestService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ride-request")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RideRequestResource {

    @Inject
    RideRequestService service;

    @POST
    public Response receiveRide(RideRequest req){
        RideRequestEntity saved = service.handleIncomingRequest(req);

        return Response.ok(saved).build();
    }
}
