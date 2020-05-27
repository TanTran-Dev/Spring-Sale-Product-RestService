package com.spring.baseproject.modules.admin.models.dtos;

import com.spring.baseproject.modules.auth.models.dtos.NewUserDto;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import io.swagger.annotations.ApiModelProperty;


public class NewAdminDto extends NewUserDto {
    @ApiModelProperty(notes = "First Name", position = 2)
    private String firstName;

    @ApiModelProperty(notes = "Last Name", position = 3)
    private String lastName;

    @ApiModelProperty(notes = "Số điện thoại", position = 4)
    private String phone;

    @ApiModelProperty(notes = "Giới tính", position = 5)
    private Gender gender;

    @ApiModelProperty(notes = "Địa chỉ", position = 6)
    private String address;

    public NewAdminDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
