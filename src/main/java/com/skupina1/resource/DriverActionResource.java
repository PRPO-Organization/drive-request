package com.skupina1.resource;


import com.skupina1.model.DriverResponse;
import com.skupina1.service.RideRequestService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/driver")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DriverActionResource {

    @Inject
    RideRequestService service;

    @POST
    @Path("/response")
    public Response respondToRide(DriverResponse res){
        service.handleDriverReply(res.rideId(), res.driverId(), res.accepted());

        return Response.ok(res).build();
    }

    @GET
    @Path("/response")
    public Response confirmRide(@QueryParam("requestId") long requestId, @QueryParam("driverId") long driverId,
                                @QueryParam("accepted") @DefaultValue("true") boolean accepted){
        service.handleDriverReply(requestId, driverId, accepted);

        String msg = accepted ? "Ride accepted" : "Ride declined";
        return Response.ok("\"message\":\"" + msg + "\"").build();
    }
}
