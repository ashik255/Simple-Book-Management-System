package com.example.main.service;

import com.example.main.entity.UserEntity;
import com.example.main.model.UserRequestModel;
import org.springframework.http.ResponseEntity;
public interface UserService {
    ResponseEntity<Object> register(UserRequestModel requestModel);
    UserEntity getAuthenticatedUser();
    ResponseEntity<Object> updateAuthenticatedUser(Long id, UserEntity updatedUser);

}
