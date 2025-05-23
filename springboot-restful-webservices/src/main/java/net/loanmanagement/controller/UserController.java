package net.loanmanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.loanmanagement.dto.UserDto;
import net.loanmanagement.dto.UserUpdateRequest;
import net.loanmanagement.model.UserRole;
import net.loanmanagement.service.UserService;
import net.loanmanagement.strategy.UserHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    private UserHandler userHandler;

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User By ID REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users REST API is used to get a all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )

    //Build Get All Active Users REST API
    // http://localhost:8080/api/users/active
    @GetMapping("active")
    public  ResponseEntity<List<UserDto>> getAllActiveUsers() {
        List<UserDto> users = userService.getAllUsers();
//        List<UserDto> activeUsers = users.stream().filter(u -> u.getIsDeleted()==null || !u.getIsDeleted()).toList();
        List<UserDto> activeUsers = users.stream().filter(u ->  Boolean.FALSE.equals(u.getIsDeleted())).toList(); //move to service layer
        return new ResponseEntity<>(activeUsers, HttpStatus.OK);
    }

    @Operation(
            summary = "Retrieve active users",
            description = "Fetch all the users where isDeleted is false or null "
    )

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )

//    //PATCH API to update only email
//    // http://localhost:8080/api/users/updateEmail
//    @PatchMapping("updateEmail/{id}")
//    public ResponseEntity<UserDto> updateEmail(@PathVariable("id") Long userId,
//                                               @RequestBody final EmailUpdateRequest email){
//        UserDto user = userService.getUserById(userId);
//        user.setEmail(email.getEmail());
//        UserDto updatedUser = userService
//        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//    }


    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody UserUpdateRequest request){
        UserDto updatedUser = userService.updateUser(userId, request);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
            userService.deleteUser(userId);
            return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/role-action")
    public ResponseEntity<String> handleRoleAction(@RequestParam UserRole role) {
        userService.getUserRoleHandler(role);
        return new ResponseEntity<>("Action processed for role: " + role, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{userId}/perform-action")
    public ResponseEntity<String> performAction(@PathVariable Long userId, @RequestParam UserRole role) {
        userService.performUserAction(userId, role);
        return ResponseEntity.ok("Action logged for userId: " + userId);
    }
}
