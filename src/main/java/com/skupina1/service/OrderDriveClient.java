package com.skupina1.service;

import com.skupina1.persistence.RideRequestEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
public class OrderDriveClient {

    //fix later
    private static final String ORDER_DRIVE_URL =
            "http://order-drive-service:8080/api/ride-confirmation";

    //give confirmation to order-drive service
    public void sendRideResponse(RideRequestEntity req) {
        System.out.println("IMPLEMENT ORDER DRIVE SERVICE");

        /*
        try {
            ClientBuilder.newClient()
                    .target(ORDER_DRIVE_URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(jakarta.ws.rs.client.Entity.json(req));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
         */
    }
}
