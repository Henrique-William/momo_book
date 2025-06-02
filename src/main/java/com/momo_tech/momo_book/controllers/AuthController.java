package com.momo_tech.momo_book.controllers;

import com.momo_tech.momo_book.dto.LoginRequest;
import com.momo_tech.momo_book.dto.RegisterRequest;
import com.momo_tech.momo_book.entity.UserEntity;
import com.momo_tech.momo_book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        if (registerRequest.isValid() && registerRequest.isRegistrationValid()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(registerRequest.getName());
            userEntity.setEmail(registerRequest.getEmail());
            userEntity.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            userEntity.setRole(registerRequest.getRole());
            userEntity.setPhoneNumber(registerRequest.getPhoneNumber());
            userRepository.save(userEntity);
            return "User registered successfully!";
        }

        return "Invalid data for register, please check your input.";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        UserEntity userEntity = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException(("User not found with email: " + loginRequest.getEmail())));

        if (loginRequest.isLoginValid() && loginRequest.isEmailValid()) {
            if (passwordEncoder.matches(loginRequest.getPassword(), userEntity.getPassword())) {
                return "Login successful! Welcome " + userEntity.getName() + ".";
            } else {
                return "invalid credentials, please try again.";
            }
        }
        return "Invalid data for login, please check your input.";
    }

}
