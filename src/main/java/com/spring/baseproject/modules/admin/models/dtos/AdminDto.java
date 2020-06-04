package com.spring.baseproject.modules.admin.models.dtos;

import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.auth.models.dtos.BaseUserProfileDto;
import com.spring.baseproject.modules.auth.models.dtos.UserDto;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;

public class AdminDto extends BaseUserProfileDto {
    public AdminDto(String id, String firstName, String lastName, String address, LocalDate birthDay, String phone, Gender gender,
                    String userId, String username, Boolean isBanned, Date lastActive) {
        super(id, firstName, lastName, address, birthDay, phone, gender, userId, username, isBanned, lastActive);
    }

    public AdminDto(Admin admin) {
        BeanUtils.copyProperties(admin, this);
        this.setUserDto(new UserDto(admin.getUser()));
    }
}

