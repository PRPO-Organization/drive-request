package com.skupina1.model;

public record DriverResponse(
        Long rideId,
        Long driverId,
        boolean accepted
) {}