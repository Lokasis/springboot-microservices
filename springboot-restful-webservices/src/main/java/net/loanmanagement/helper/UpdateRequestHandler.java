package net.loanmanagement.helper;

import net.loanmanagement.dto.UserUpdateRequest;
import net.loanmanagement.model.User;
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
