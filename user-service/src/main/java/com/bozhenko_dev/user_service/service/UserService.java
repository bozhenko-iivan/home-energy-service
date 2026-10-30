package com.bozhenko_dev.user_service.service;

import com.bozhenko_dev.user_service.dto.UserRequestDto;
import com.bozhenko_dev.user_service.dto.UserResponseDto;
import com.bozhenko_dev.user_service.entity.User;
import com.bozhenko_dev.user_service.exception.UserNotFoundException;
import com.bozhenko_dev.user_service.mapper.UserMapper;
import com.bozhenko_dev.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto input) {
        User userToSave = UserMapper.toModel(input);
        User savedUser = userRepository.save(userToSave);

        return UserMapper.toDto(savedUser);
    }

    public UserResponseDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.map(UserMapper::toDto).orElse(null);
    }

    public void updateUser(Long id, UserRequestDto userDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found")
        );

        user.setName(userDto.name());
        user.setSurname(userDto.surname());
        user.setEmail(userDto.email());
        user.setAddress(userDto.address());
        user.setAlerting(userDto.isAlerting());
        user.setEnergyAlertingThreshold(userDto.energyAlertingThreshold());

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id " + id + " not found")
        );

        userRepository.delete(user);
    }
}