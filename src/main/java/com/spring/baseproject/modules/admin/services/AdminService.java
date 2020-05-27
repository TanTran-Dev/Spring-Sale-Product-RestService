package com.spring.baseproject.modules.admin.services;

import com.spring.baseproject.base.models.BaseResponse;
import com.spring.baseproject.constants.ResponseValue;
import com.spring.baseproject.modules.admin.models.dtos.AdminDto;
import com.spring.baseproject.modules.admin.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public BaseResponse getAdminDto(String adminId){
        AdminDto adminDto = adminRepository.getAdminDto(adminId);
        if (adminDto == null){
            return new BaseResponse(ResponseValue.ADMIN_NOT_FOUND);
        }
        return new BaseResponse(ResponseValue.SUCCESS, adminDto);
    }
}
