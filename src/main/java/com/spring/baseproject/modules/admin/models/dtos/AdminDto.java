package com.spring.baseproject.modules.admin.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.baseproject.modules.admin.models.entities.Admin;
import com.spring.baseproject.modules.auth.models.dtos.BaseUserProfileDto;
import com.spring.baseproject.modules.auth.models.dtos.UserDto;
import com.spring.baseproject.modules.auth.models.entities.UserType;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto{
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

    public AdminDto(Admin admin) {
        BeanUtils.copyProperties(admin, this);
    }
}

