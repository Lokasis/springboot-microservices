package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.dto.UserUpdateRequest;
import net.javaguides.springboot.model.UserRole;
import net.javaguides.springboot.strategy.UserRoleHandler;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserUpdateRequest request);

    void deleteUser(Long userId);

    UserRoleHandler getUserRoleHandler(UserRole userRole);

    void performUserAction(Long userId, UserRole role);
}
