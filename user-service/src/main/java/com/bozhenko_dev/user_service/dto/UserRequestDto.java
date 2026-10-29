package com.bozhenko_dev.user_service.dto;

import lombok.Builder;

@Builder
public record UserRequestDto(
        String name,
        String surname,
        String email,
        String address,
        boolean isAlerting,
        double energyAlertingThreshold
) { }