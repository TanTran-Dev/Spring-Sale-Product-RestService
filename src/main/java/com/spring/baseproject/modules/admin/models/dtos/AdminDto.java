package com.spring.baseproject.modules.admin.models.dtos;

import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.auth.models.dtos.BaseUserProfileDto;
import com.spring.baseproject.modules.auth.models.dtos.UserDto;
import com.spring.baseproject.modules.auth.models.entities.UserType;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class AdminDto extends BaseUserProfileDto {
    public AdminDto(String id, String firstName, String lastName, String address, Date birthDay, String phone, Gender gender, String avatarUrl, String imageCoverUrl,
                    String userId, String username, UserType userType, Boolean isBanned, Date lastActive) {
        super(id, firstName, lastName, address, birthDay, phone, gender, avatarUrl, imageCoverUrl, userId, username, userType, isBanned, lastActive);
    }

    public AdminDto(Admin admin) {
        BeanUtils.copyProperties(admin, this);
        this.setUserDto(new UserDto(admin.getUser()));
    }
}

