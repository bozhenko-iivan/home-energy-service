package com.bozhenko_dev.device_service.controller;

import com.bozhenko_dev.device_service.dto.DeviceRequestDto;
import com.bozhenko_dev.device_service.dto.DeviceResponseDto;
import com.bozhenko_dev.device_service.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponseDto> getDeviceById(@PathVariable Long id) {
        DeviceResponseDto deviceResponseDto = deviceService.getDeviceById(id);
        return new ResponseEntity<>(deviceResponseDto, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<DeviceResponseDto> createDevice(@RequestBody DeviceRequestDto deviceRequestDto) {
        DeviceResponseDto deviceResponseDto = deviceService.createDevice(deviceRequestDto);
        return new ResponseEntity<>(deviceResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDevice(@PathVariable Long id,
                                               @RequestBody DeviceRequestDto deviceRequestDto) {
        deviceService.updateDevice(id, deviceRequestDto);
        return new ResponseEntity<>("Device updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return new ResponseEntity<>("Device deleted successfully", HttpStatus.NO_CONTENT);
    }
}
