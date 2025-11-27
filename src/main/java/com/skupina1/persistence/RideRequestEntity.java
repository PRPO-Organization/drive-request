package com.skupina1.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "ride_requests")
public class RideRequestEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String pickupLocation;
    private String dropoffLocation;
    private Long driverId;
    private String status;


    public Long getId() { return id; }
    public String getPickupLocation() { return this.pickupLocation; }
    public String getDropoffLocation() { return this.dropoffLocation; }
    public Long getDriverId() { return this.driverId; }
    public String getStatus() { return this.status; }

    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }
    public void setDropoffLocation(String dropoffLocation) { this.dropoffLocation = dropoffLocation; }
    public void setDriverId(Long driverId) { this.driverId = driverId; }
    public void setStatus(String status) { this.status = status; }
}
