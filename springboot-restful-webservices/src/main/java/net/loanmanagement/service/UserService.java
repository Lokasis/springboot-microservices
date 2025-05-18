package net.loanmanagement.service;

import net.loanmanagement.dto.UserDto;
import net.loanmanagement.dto.UserUpdateRequest;
import net.loanmanagement.model.UserRole;
import net.loanmanagement.strategy.UserRoleHandler;

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
