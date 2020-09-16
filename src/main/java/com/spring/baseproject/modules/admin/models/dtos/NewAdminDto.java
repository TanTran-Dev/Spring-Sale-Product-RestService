package com.spring.baseproject.modules.admin.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.baseproject.modules.auth.models.dtos.NewUserDto;
import com.spring.baseproject.modules.auth.models.entities.UserType;
import com.spring.baseproject.modules.demo_building.models.entities.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ApiModelProperty(notes = "Loại người dùng", position = 10)
    private UserType userType;
}
