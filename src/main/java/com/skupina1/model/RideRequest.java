package com.skupina1.model;

public record RideRequest(
    String pickupLocation,
    String dropoffLocation,
    Long driverId
) {}