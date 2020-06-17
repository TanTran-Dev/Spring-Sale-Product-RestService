package com.spring.baseproject.modules.auth.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.baseproject.modules.auth.models.entities.UserType;
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
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDay;

    @ApiModelProperty(notes = "số điện thoại")
    private String phone;

    @ApiModelProperty(notes = "giới tính")
    private Gender gender;

    @ApiModelProperty(notes = "Ảnh đại diện")
    private String avatarUrl;

    @ApiModelProperty(notes = "Ảnh bìa")
    private String imageCoverUrl;

    @ApiModelProperty(notes = "thông tin tài khoản người dùng")
    private UserDto userDto;

    public BaseUserProfileDto() {
    }

    public BaseUserProfileDto(String id, String firstName, String lastName, String address, Date birthDay,
                              String phone, Gender gender, String avatarUrl, String imageCoverUrl, String userId, String username,
                              UserType userType,
                              Boolean isBanned, //should be Boolean, not boolean, because isBanned may be null
                              Date lastActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthDay = birthDay;
        this.phone = phone;
        this.gender = gender;
        this.avatarUrl = avatarUrl;
        this.imageCoverUrl = imageCoverUrl;
        this.userDto = new UserDto(userId, username, userType, isBanned, lastActive);
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getImageCoverUrl() {
        return imageCoverUrl;
    }

    public void setImageCoverUrl(String imageCoverUrl) {
        this.imageCoverUrl = imageCoverUrl;
    }
}
