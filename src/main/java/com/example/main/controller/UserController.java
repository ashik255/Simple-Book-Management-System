package com.example.main.controller;

import com.example.main.entity.UserEntity;
import com.example.main.model.AuthenticationRequest;
import com.example.main.model.UserRequestModel;
import com.example.main.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private UserRequestModel requestModel;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody UserRequestModel requestModel){
        this.requestModel = requestModel;
        return userService.register(requestModel);
    }
    @GetMapping("/profile")
    public ResponseEntity<UserEntity> getAuthenticatedUserProfile(@RequestBody AuthenticationRequest authenticationRequest) {
        // Get the authenticated user's profile (excluding the password)
        UserEntity authenticatedUser = userService.getAuthenticatedUser();
        return ResponseEntity.ok(authenticatedUser);
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Object> updateAuthenticatedUserProfile(@PathVariable ("id") Long id, @RequestBody UserEntity updatedUser) {
        // Update the profile of the authenticated user
        ResponseEntity<Object> updatedUserProfile = userService.updateAuthenticatedUser(id,updatedUser);
        return ResponseEntity.ok(updatedUserProfile);
    }

}
