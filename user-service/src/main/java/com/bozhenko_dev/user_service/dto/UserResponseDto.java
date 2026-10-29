package com.bozhenko_dev.user_service.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(
        Long id,
        String name,
        String surname,
        String email,
        String address,
        boolean isAlerting,
        double energyAlertingThreshold
) {}
