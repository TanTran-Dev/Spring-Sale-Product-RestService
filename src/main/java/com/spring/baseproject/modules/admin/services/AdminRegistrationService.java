package com.spring.baseproject.modules.admin.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.admin.models.dtos.NewAdminDto;
import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.admin.repositories.AdminRepository;
import com.spring.baseproject.modules.auth.models.entities.User;
import com.spring.baseproject.modules.auth.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminRegistrationService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRegistrationService userRegistrationService;


    @Transactional(rollbackFor = Exception.class)
    public BaseResponse registerNewAdmin(NewAdminDto newAdminDto) {

        User user = userRegistrationService.registerUser(newAdminDto);
        if (user == null) {
            return new BaseResponse(ResponseValue.USERNAME_EXISTS);
        }

        Admin admin = new Admin(newAdminDto, user);
        if (admin.getContactEmail() == null){
            admin.setContactEmail(user.getUsername());
        }

        admin.getUser().setUserType(newAdminDto.getUserType());
        adminRepository.save(admin);
        return new BaseResponse(ResponseValue.SUCCESS);
    }
}
