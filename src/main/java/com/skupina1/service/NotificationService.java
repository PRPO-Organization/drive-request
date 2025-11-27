package com.skupina1.service;

import com.skupina1.persistence.RideRequestEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Entity;

@ApplicationScoped
public class NotificationService {

    private static final String NOTIFY_URL = "http://localhost:8081/notifications/send";

    //send notifications to nearby drivers
    public void notifyDriversNearby(RideRequestEntity req){
        System.out.println("IMPLEMENT NOTIFICATION SYSTEM");

        /*  for when the other APIs are finished
        try {
            ClientBuilder.newClient()
                    .target(NOTIFY_URL)
                    .request(MediaType.APPLICATION_JSON)
                    .post(jakarta.ws.rs.client.Entity.json(req));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
         */
    }
}
