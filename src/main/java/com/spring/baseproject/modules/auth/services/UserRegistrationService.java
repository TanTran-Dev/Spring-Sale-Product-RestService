package com.spring.baseproject.modules.auth.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.auth.models.dtos.NewUserDto;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public BaseResponse registerNewUser(NewUserDto newUserDto) {
        if (userRepository.existsByUsername(newUserDto.getUsername())) {
            return new BaseResponse(ResponseValue.USERNAME_EXISTS);
        }
        User user = new User();
        user.setUsername(newUserDto.getUsername());
        String hashPassword = passwordEncoder.encode(newUserDto.getPassword());
        user.setPassword(hashPassword);
        userRepository.save(user);
        return new BaseResponse(ResponseValue.SUCCESS);
    }

    public User registerUser(NewUserDto newUserDto) {
        if (userRepository.existsByUsername(newUserDto.getUsername())) {
            return null;
        }
        User user = new User();
        user.setUsername(newUserDto.getUsername());
        String hashPassword = passwordEncoder.encode(newUserDto.getPassword());
        user.setPassword(hashPassword);

        return userRepository.save(user);
    }
}
