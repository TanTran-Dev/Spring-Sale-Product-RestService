package com.spring.baseproject.modules.customer.models.dtos;

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
public class NewCustomerDto extends NewUserDto {
    @ApiModelProperty(notes = "First Name", position = 2)
    private String firstName;

    @ApiModelProperty(notes = "Last Name", position = 3)
    private String lastName;

    @ApiModelProperty(notes = "Địa chỉ", position = 4)
    private String address;

    @ApiModelProperty(notes = "Ngày sinh", position = 5)
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date birthDay;

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
}
