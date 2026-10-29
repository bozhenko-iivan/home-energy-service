package com.bozhenko_dev.user_service.mapper;

import com.bozhenko_dev.user_service.dto.UserRequestDto;
import com.bozhenko_dev.user_service.dto.UserResponseDto;
import com.bozhenko_dev.user_service.entity.User;

public class UserMapper {
    public static UserResponseDto toDto(User user) {
        if (user == null) {
            return null;
        }

        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .address(user.getAddress())
                .isAlerting(user.isAlerting())
                .energyAlertingThreshold(user.getEnergyAlertingThreshold())
                .build();
    }

    public static User toModel(UserRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return User.builder()
                .name(dto.name())
                .surname(dto.surname())
                .email(dto.email())
                .address(dto.address())
                .alerting(dto.isAlerting())
                .energyAlertingThreshold(dto.energyAlertingThreshold())
                .build();
    }
}