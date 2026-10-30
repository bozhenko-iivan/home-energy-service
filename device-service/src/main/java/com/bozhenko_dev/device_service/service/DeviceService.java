package com.bozhenko_dev.device_service.service;

import com.bozhenko_dev.device_service.dto.DeviceRequestDto;
import com.bozhenko_dev.device_service.dto.DeviceResponseDto;
import com.bozhenko_dev.device_service.entity.Device;
import com.bozhenko_dev.device_service.exception.DeviceNotFoundException;
import com.bozhenko_dev.device_service.mapper.DeviceMapper;
import com.bozhenko_dev.device_service.repository.DeviceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceResponseDto getDeviceById(Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(
                () -> new DeviceNotFoundException("Device with id " + id + " not found")
        );
        return DeviceMapper.toDto(device);
    }

    @Transactional()
    public DeviceResponseDto createDevice(DeviceRequestDto deviceRequestDto) {
        Device toSave = DeviceMapper.toEntity(deviceRequestDto);
        Device saved = deviceRepository.save(toSave);
        return DeviceMapper.toDto(saved);
    }

    @Transactional()
    public void updateDevice(Long id, DeviceRequestDto deviceRequestDto) {
        Device existingDevice = deviceRepository.findById(id).orElseThrow(
                () -> new DeviceNotFoundException("Device with id " + id + " not found")
        );

        existingDevice.setName(deviceRequestDto.name());
        existingDevice.setType(deviceRequestDto.type());
        existingDevice.setLocation(deviceRequestDto.location());
        existingDevice.setUserId(deviceRequestDto.userId());
    }

    @Transactional()
    public void deleteDevice(Long id) {
        if (!deviceRepository.existsById(id)) {
            throw new DeviceNotFoundException("Device with id " + id + " not found");
        }
        deviceRepository.deleteById(id);
    }
}
