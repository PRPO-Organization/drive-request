package com.skupina1.service;

import com.skupina1.model.Notification;
import com.skupina1.persistence.RideRequestEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.client.Entity;

@ApplicationScoped
public class NotificationService {

    private static final String NOTIFY_URL = "http://localhost:8081/notifications/send-html";

    //implement logic to get this automatically at boot
    private static final String jwt_token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbkB0ZXN0LmNvbSIsInJvbGUiOiJBRE1JTiIsImlhdCI6MTc2NDI0ODY1MywiZXhwIjoxNzY0MzM1MDUzfQ.tGryOrLCYzXyU5R9yDwZXBed_wKif5JTfQx-mDwQzpjH9ZQ2f0oBnlVJyGDqhU1R";

    //send notifications to nearby drivers
    public void notifyDriversNearby(RideRequestEntity req){
        //System.out.println("IMPLEMENT NOTIFICATION SYSTEM");

        Notification email = new Notification();
        email.setRecipient("stefan.jakjoski@gmail.com");        // implement driver email fetch
        email.setSubject("New Ride Request!");
        email.setBody(Notification.requestEmailBody(req.getId(), req.getDriverId()));

        /*  for when the other APIs are finished
         */
        try {
            ClientBuilder.newClient()
                    .target(NOTIFY_URL)
                    .request(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + jwt_token)
                    .post(jakarta.ws.rs.client.Entity.json(email));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
