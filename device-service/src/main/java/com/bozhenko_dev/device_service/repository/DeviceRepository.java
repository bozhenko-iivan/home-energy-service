package com.bozhenko_dev.device_service.repository;

import com.bozhenko_dev.device_service.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
