package com.spring.baseproject.modules.auth.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.auth.models.dtos.UserDto;
import com.spring.baseproject.modules.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public BaseResponse getUserDto(String userID, Date createdDate) {
        UserDto userDto = userRepository.getUserDto(userID, createdDate);
        if (userDto == null) {
            return new BaseResponse(ResponseValue.USER_NOT_FOUND);
        }
        return new BaseResponse<>(ResponseValue.SUCCESS, userDto);
    }

}
