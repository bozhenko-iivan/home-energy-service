package com.bozhenko_dev.device_service.entity;

import com.bozhenko_dev.device_service.model.DeviceType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "device")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private DeviceType type;
    private String location;
    @Column(name = "user_id")
    private Long userId;
}
