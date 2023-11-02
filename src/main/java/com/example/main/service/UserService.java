package com.example.main.service;

import com.example.main.entity.UserEntity;
import com.example.main.model.UserRequestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface UserService {
    ResponseEntity<Object> register(UserRequestModel requestModel);

    UserEntity getAuthenticatedUser();

    ResponseEntity<Object> updateAuthenticatedUser(Long id, UserEntity updatedUser);

//    UserEntity updateAuthenticatedUser(UserEntity updatedUser);


//    UserEntity getAuthenticatedUser(Authentication authentication);
}
