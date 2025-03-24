package net.javaguides.springboot.helper;

import net.javaguides.springboot.dto.UserUpdateRequest;
import net.javaguides.springboot.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UpdateRequestHandler {

    public User createUserDto(UserUpdateRequest request, User existingUser) {
        if(request.getFirstName() != null) existingUser.setFirstName(request.getFirstName());
        if(request.getLastName() != null) existingUser.setLastName(request.getLastName());
        if(request.getEmail() !=null) existingUser.setEmail(request.getEmail());
        if(request.getPhoneNumber() !=null) existingUser.setPhoneNumber(request.getPhoneNumber());
        return existingUser;
    }
}
