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
    private Date birthDay;

    public CustomerDto(String id, String firstName, String lastName, String address, Date birthDay, String phone,
                       Gender gender, String userId, String username, Boolean isBanned, Date lastActive) {
        super(id, firstName, lastName, address, birthDay, phone, gender, userId, username, isBanned, lastActive);
        this.birthDay = birthDay;
    }

    public CustomerDto(Customer customer) {
        BeanUtils.copyProperties(customer, this);
        this.setUserDto(new UserDto(customer.getUser()));
    }

    @Override
    public Date getBirthDay() {
        return birthDay;
    }

    @Override
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
