package com.bozhenko_dev.device_service.mapper;

import com.bozhenko_dev.device_service.dto.DeviceRequestDto;
import com.bozhenko_dev.device_service.dto.DeviceResponseDto;
import com.bozhenko_dev.device_service.entity.Device;

public class DeviceMapper {
    public static DeviceResponseDto toDto(Device device) {
        if (device == null) {
            return null;
        }

        return DeviceResponseDto.builder()
                .id(device.getId())
                .name(device.getName())
                .type(device.getType())
                .location(device.getLocation())
                .userId(device.getUserId())
                .build();
    }

    public static Device toEntity(DeviceRequestDto deviceRequestDto) {
        if (deviceRequestDto == null) {
            return null;
        }
        return Device.builder()
                .name(deviceRequestDto.name())
                .type(deviceRequestDto.type())
                .location(deviceRequestDto.location())
                .userId(deviceRequestDto.userId())
                .build();
    }
}
