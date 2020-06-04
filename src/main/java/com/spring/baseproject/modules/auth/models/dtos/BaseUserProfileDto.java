package com.spring.baseproject.modules.auth.models.dtos;

import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.Date;

public class BaseUserProfileDto {
    @ApiModelProperty(notes = "id")
    private String id;

    @ApiModelProperty(notes = "first name")
    private String firstName;

    @ApiModelProperty(notes = "last name")
    private String lastName;

    @ApiModelProperty(notes = "địa chỉ")
    private String address;

    @ApiModelProperty(notes = "địa chỉ")
    private LocalDate birthDay;

    @ApiModelProperty(notes = "số điện thoại")
    private String phone;

    @ApiModelProperty(notes = "giới tính")
    private Gender gender;

    @ApiModelProperty(notes = "thông tin tài khoản người dùng")
    private UserDto userDto;

    public BaseUserProfileDto() {
    }

    public BaseUserProfileDto(String id, String firstName, String lastName, String address, LocalDate birthDay,
                              String phone, Gender gender, String userId, String username,
                              Boolean isBanned, //should be Boolean, not boolean, because isBanned may be null
                              Date lastActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDay = birthDay;
        this.phone = phone;
        this.gender = gender;
        this.userDto = new UserDto(userId, username, isBanned, lastActive);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}
