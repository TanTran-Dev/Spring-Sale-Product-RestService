package com.spring.baseproject.modules.customer.models.dtos;

import com.spring.baseproject.modules.auth.models.dtos.BaseUserProfileDto;
import com.spring.baseproject.modules.auth.models.dtos.UserDto;
import com.spring.baseproject.modules.auth.models.entities.UserType;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;

public class CustomerDto extends BaseUserProfileDto {

    public CustomerDto(String id, String firstName, String lastName, String address, Date birthDay, String phone,
                       Gender gender, String avatarUrl, String imageCoverUrl, String userId, String username, UserType userType, Boolean isBanned, Date lastActive) {
        super(id, firstName, lastName, address, birthDay, phone, gender, avatarUrl, imageCoverUrl, userId, username, userType, isBanned, lastActive);
    }

    public CustomerDto(Customer customer) {
        BeanUtils.copyProperties(customer, this);
        this.setUserDto(new UserDto(customer.getUser()));
    }
}
