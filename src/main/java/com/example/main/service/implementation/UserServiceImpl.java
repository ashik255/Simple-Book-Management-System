package com.example.main.service.implementation;

import com.example.main.entity.UserEntity;
import com.example.main.model.AuthenticationResponse;
import com.example.main.model.UserRequestModel;
import com.example.main.repository.UserRepository;
import com.example.main.service.UserService;
import com.example.main.utlis.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public ResponseEntity<Object> register(UserRequestModel requestModel) {
        UserEntity userEntity = UserEntity.builder()
                .email(requestModel.getEmail())
                .role(requestModel.getRole())
                .fullName(requestModel.getFullName())
                .username(requestModel.getUsername())
                .dateRegistered(requestModel.getDateRegistered())
                .password(passwordEncoder.encode(requestModel.getPassword()))
                .build();
        userRepository.save(userEntity);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .token(jwtService.generateToken(userEntity))
                .build();
        return new ResponseEntity<>(authenticationResponse, HttpStatus.CREATED);
    }

    @Override
    public UserEntity getAuthenticatedUser() {
        List<UserEntity> userEntities=userRepository.findAll();
        return (UserEntity) userEntities;
    }

    @Override
    public ResponseEntity<Object> updateAuthenticatedUser(Long id, UserEntity updatedUser) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setEmail(updatedUser.getEmail());
        userEntity.setFullName(updatedUser.getFullName());
        userEntity.setPassword(updatedUser.getPassword());
        userEntity.setRole(updatedUser.getRole());
        userEntity.setUsername(updatedUser.getUsername());
        userEntity.setDateRegistered(updatedUser.getDateRegistered());
        return new ResponseEntity<>(userRepository.save(userEntity),HttpStatus.OK);
    }

}

