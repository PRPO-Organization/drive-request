package com.skupina1.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.ClientBuilder;

@ApplicationScoped
public class DriverStatusService {

    //fix endpoint
    private static final String ACCOUNT_URL = "http://account-management:8080/drivers/status";

    //send status updates to acc-management
    public void updateDriverStatus(Long driverId, String status) {
        System.out.println("IMPLEMENT DRIVER STATUS SERVICE");

        /*
        try {
            ClientBuilder.newClient()
                    .target(ACCOUNT_URL + "/" + driverId)
                    .request()
                    .put(jakarta.ws.rs.client.Entity.text(status));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
         */
    }
}
