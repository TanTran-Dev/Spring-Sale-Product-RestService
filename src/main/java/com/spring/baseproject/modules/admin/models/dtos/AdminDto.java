package com.spring.baseproject.modules.admin.models.dtos;
import com.spring.baseproject.modules.auth.models.dtos.BaseUserProfileDto;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;

import java.util.Date;

public class AdminDto extends BaseUserProfileDto {
    public AdminDto(String id, String firstName, String lastName, String address, String phone, Gender gender,
                    String userId, String username, Boolean isBanned, Date lastActive) {
        super(id, firstName, lastName, address, phone, gender, userId, username, isBanned, lastActive);
    }
}

