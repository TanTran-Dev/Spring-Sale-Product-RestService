package com.spring.baseproject.modules.customer.models.dtos;

import com.spring.baseproject.modules.auth.models.dtos.BaseUserProfileDto;
import com.spring.baseproject.modules.auth.models.dtos.UserDto;
import com.spring.baseproject.modules.customer.models.entities.Customer;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.Date;

public class CustomerDto extends BaseUserProfileDto {
    @ApiModelProperty(notes = "ngày sinh")
    private LocalDate birthDay;

    public CustomerDto(String id, String firstName, String lastName, LocalDate birthDay, String address, String phone, Gender gender, String userId, String username, Boolean isBanned, Date lastActive) {
        super(id, firstName, lastName, address, phone, gender, userId, username, isBanned, lastActive);
        this.birthDay = birthDay;
    }

    public CustomerDto(Customer customer) {
        BeanUtils.copyProperties(customer, this);
        this.setUserDto(new UserDto(customer.getUser()));
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
