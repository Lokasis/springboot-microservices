package net.loanmanagement.service.impl;

import lombok.AllArgsConstructor;
import net.loanmanagement.dto.UserDto;
import net.loanmanagement.dto.UserUpdateRequest;
import net.loanmanagement.factory.UserRoleHandlerFactory;
import net.loanmanagement.model.User;
import net.loanmanagement.exception.EmailAlreadyExistsException;
import net.loanmanagement.exception.ResourceNotFoundException;
import net.loanmanagement.exception.UserSoftDeletedException;
import net.loanmanagement.helper.UpdateRequestHandler;
import net.loanmanagement.mapper.AutoUserMapper;
import net.loanmanagement.model.UserRole;
import net.loanmanagement.repository.UserRepository;
import net.loanmanagement.service.UserService;
import net.loanmanagement.strategy.UserRoleHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private UpdateRequestHandler updateRequestHandler;

    private UserRoleHandlerFactory userRoleHandlerFactory;

    @Override
    public UserDto createUser(UserDto userDto) {

        // Convert UserDto into User JPA Entity
       // User user = UserMapper.mapToUser(userDto);

        //User user = modelMapper.map(userDto, User.class);

        if(userRepository.findByEmailAndIsDeletedTrue(userDto.getEmail()).isPresent()) {
            throw new UserSoftDeletedException("User with this email had already exists but was already deleted");
        }

        if(userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        // Convert User JPA entity to UserDto
        //UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        //UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

        return savedUserDto;
    }



    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository
                .findById(userId)
                .filter(u-> u.getIsDeleted()==null || !u.getIsDeleted())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId)
        );
        //return UserMapper.mapToUserDto(user);
        //return modelMapper.map(user, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto)
//                .collect(Collectors.toList());

//        return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
//                .collect(Collectors.toList());

        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserUpdateRequest request) {

        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

        User user = updateRequestHandler.createUserDto(request, existingUser);
        User updatedUser = userRepository.save(user);
        //return UserMapper.mapToUserDto(updatedUser);
        //return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {

        UserDto existingUser = getUserById(userId);
        User user = AutoUserMapper.MAPPER.mapToUser(existingUser);
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    @Override
    public UserRoleHandler getUserRoleHandler(UserRole userRole) {
        return userRoleHandlerFactory.getUserRoleHandler(userRole);
    }

    @Override
    public void performUserAction(Long userId, UserRole role) {
        UserRoleHandler handler = getUserRoleHandler(role);
        handler.performUserSpecificAction(userId);
    }
}
