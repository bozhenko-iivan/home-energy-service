package com.bozhenko_dev.device_service.dto;

import com.bozhenko_dev.device_service.model.DeviceType;
import lombok.Builder;

@Builder
public record DeviceResponseDto(
        Long id,
        String name,
        DeviceType type,
        String location,
        Long userId
) { }