package com.spring.baseproject.modules.admin.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.admin.models.dtos.AdminDto;
import com.spring.baseproject.modules.admin.models.dtos.NewAdminDto;
import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.admin.repositories.AdminRepository;
import com.spring.baseproject.modules.auth.models.dtos.UserDto;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public BaseResponse getAdminDto(String adminId){
        AdminDto adminDto = adminRepository.getAdminDto(adminId);
        if (adminDto == null){
            return new BaseResponse(ResponseValue.ADMIN_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, adminDto);
    }

    public BaseResponse updateAdmin(String adminId, NewAdminDto newAdminProfileDto){
        Admin admin = adminRepository.findFirstById(adminId);
        if (admin == null){
            return new BaseResponse(ResponseValue.ADMIN_NOT_FOUND);
        }

        User user = userRepository.findFirstById(adminId);
        user.setUsername(newAdminProfileDto.getUsername());
        user.setPassword(passwordEncoder.encode(newAdminProfileDto.getPassword()));
        user.setUserType(newAdminProfileDto.getUserType());

        admin.setUser(user);
        admin.update(newAdminProfileDto);
        adminRepository.save(admin);

        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
