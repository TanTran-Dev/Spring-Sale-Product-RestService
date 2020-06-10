package com.spring.baseproject.modules.admin.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.baseproject.modules.auth.models.dtos.NewUserDto;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.Date;


public class NewAdminDto extends NewUserDto {
    @ApiModelProperty(notes = "Họ", position = 2)
    private String firstName;

    @ApiModelProperty(notes = "Tên", position = 3)
    private String lastName;

    @ApiModelProperty(notes = "Số điện thoại", position = 4)
    private String phone;

    @ApiModelProperty(notes = "Giới tính", position = 5)
    private Gender gender;

    @ApiModelProperty(notes = "Địa chỉ", position = 6)
    private String address;

    @ApiModelProperty(notes = "Ảnh đại diện", position = 7)
    private String avatarUrl;

    @ApiModelProperty(notes = "Ảnh bìa", position = 8)
    private String imageCoverUrl;

    @ApiModelProperty(notes = "Ngày sinh", position = 9)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date birthDay;

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
