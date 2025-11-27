package com.skupina1.service;

import com.skupina1.model.RideRequest;
import com.skupina1.persistence.RideRequestEntity;
import com.skupina1.persistence.RideRequestRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RideRequestService {

    @Inject
    RideRequestRepository repo;

    @Inject
    NotificationService notificationService;

    @Inject
    DriverStatusService driverStatusService;

    @Inject
    OrderDriveClient orderDriveClient;

    public RideRequestEntity handleIncomingRequest(RideRequest req){
        RideRequestEntity en = new RideRequestEntity();
        en.setPickupLocation(req.pickupLocation());
        en.setDropoffLocation(req.dropoffLocation());
        en.setDriverId(req.driverId());
        en.setStatus("NEW");

        repo.save(en);
        notificationService.notifyDriversNearby(en);

        return en;
    }

    public void handleDriverReply(long requestId, long driverId, boolean accepted){
        RideRequestEntity en = repo.findById(requestId);
        System.out.println("Fetched entity id: " + en.getId());

        en.setStatus(accepted ? "ACCEPTED" : "DECLINED");
        repo.update(en);

        driverStatusService.updateDriverStatus(driverId, accepted ? "busy" : "available");
        orderDriveClient.sendRideResponse(en);
    }
}
