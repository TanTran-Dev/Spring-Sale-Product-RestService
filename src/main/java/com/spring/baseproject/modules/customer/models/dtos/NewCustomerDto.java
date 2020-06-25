package com.spring.baseproject.modules.customer.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.baseproject.modules.auth.models.dtos.NewUserDto;
import com.spring.baseproject.modules.auth.models.entities.UserType;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class NewCustomerDto extends NewUserDto {
    @ApiModelProperty(notes = "First Name", position = 2)
    private String firstName;

    @ApiModelProperty(notes = "Last Name", position = 3)
    private String lastName;

    @ApiModelProperty(notes = "Địa chỉ", position = 4)
    private String address;

    @ApiModelProperty(notes = "Ngày sinh", position = 5)
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDay;

    @ApiModelProperty(notes = "Số điện thoại", position = 6)
    private String phone;

    @ApiModelProperty(notes = "Giới tính", position = 7)
    private Gender gender;

    @ApiModelProperty(notes = "Ảnh đại diện", position = 8)
    private String avatarUrl;

    @ApiModelProperty(notes = "Ảnh bìa", position = 9)
    private String imageCoverUrl;

    @ApiModelProperty(notes = "Loại người dùng", position = 10)
    private UserType userType;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
